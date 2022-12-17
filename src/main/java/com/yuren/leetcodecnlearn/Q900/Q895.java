package com.yuren.leetcodecnlearn.Q900;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-07-30 21:49
 */
public class Q895 {

    private static HashMap<Integer, Integer> KF;
    private static HashMap<Integer, LinkedList<Integer>> FK;

    int maxFreq;

    public Q895() {
        KF = new HashMap<Integer, Integer>();
        FK = new HashMap<Integer, LinkedList<Integer>>();
        maxFreq = 0;
    }

    public void push(int val) {
        int newFreq = KF.getOrDefault(val, 0) + 1;
        KF.put(val, newFreq);
        if (maxFreq < newFreq) {
            maxFreq++;
        }
        FK.putIfAbsent(newFreq, new LinkedList<Integer>());
        FK.get(newFreq).push(val);
    }

    public int pop() {
        int res = FK.get(maxFreq).pop();
        if (FK.get(maxFreq).isEmpty()) {
            FK.remove(maxFreq);
            maxFreq--;
        }
        KF.put(res, KF.get(res) - 1);
        return res;
    }
}
