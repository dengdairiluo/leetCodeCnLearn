package com.yuren.leetcodecnlearn.Q700;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-05-09 22:10
 */
public class Q710 {
    Map<Integer, Integer> m;
    Random r;
    int wLen;

    public Q710(int n, int[] b) {
        m = new HashMap<>();
        r = new Random();
        wLen = n - b.length;
        Set<Integer> w = new HashSet<>();
        for (int i = wLen; i < n; i++) w.add(i);
        for (int x : b) w.remove(x);
        Iterator<Integer> wi = w.iterator();
        for (int x : b)
            if (x < wLen)
                m.put(x, wi.next());
    }

    public int pick() {
        int k = r.nextInt(wLen);
        return m.getOrDefault(k, k);
    }
}
