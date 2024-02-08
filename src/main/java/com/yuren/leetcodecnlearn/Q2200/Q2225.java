package com.yuren.leetcodecnlearn.Q2200;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-02-08 23:45
 */
public class Q2225 {
    public List<List<Integer>> findWinners(int[][] matches) {
        return findWinners2(matches);
    }

    public List<List<Integer>> findWinners1(int[][] matches) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        Map<Integer, Integer> lostmap = new HashMap<>();
        for (int[] match : matches) {
            int win = match[0];
            int lost = match[1];
            lostmap.put(match[1], lostmap.getOrDefault(match[1], 0) + 1);
            //同样要把赢家加进去，设置输的场次为0或者当前输场
            lostmap.put(match[0], lostmap.getOrDefault(match[0], 0));
        }
        for (int key : lostmap.keySet()) {
            if (lostmap.get(key) == 0) {
                l1.add(key);
            } else if (lostmap.get(key) == 1) {
                l2.add(key);
            }
        }
        Collections.sort(l1);
        Collections.sort(l2);
        res.add(l1);
        res.add(l2);
        return res;
    }

    //这里因为队员的号码小于100000，我们也可以借鉴bucket排序的想法，直接定义长度为100001的数组
    public List<List<Integer>> findWinners2(int[][] matches) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        int[] loss = new int[100001];
        for (int[] match : matches) {
            int win = match[0];
            int lost = match[1];
            //还未初始化，设置胜利者的输场次为-1
            if (loss[win] == 0) {
                loss[win] = -1;
            }
            //输家之前一直赢没输过，那么记输场次为1
            if (loss[lost] == -1) {
                loss[lost] = 1;
            }
            //不管输家是否未初始化，直接把输场次+1就行，因为初始值为0
            else {
                loss[lost] = loss[lost] + 1;
            }
        }
        for (int i = 1; i < loss.length; i++) {
            if (loss[i] == -1) l1.add(i);
            if (loss[i] == 1) l2.add(i);
        }
        res.add(l1);
        res.add(l2);
        return res;

    }
}
