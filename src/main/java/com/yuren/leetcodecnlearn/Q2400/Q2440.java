package com.yuren.leetcodecnlearn.Q2400;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-05-27 下午11:57
 */
public class Q2440 {
    public int componentValue(int[] nums, int[][] edges) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        boolean[] v = new boolean[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;
        int min = 99;
        for (int x : nums) {
            sum += x;
            min = Math.min(min, x);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = min; i <= (int) Math.sqrt(sum); i++) {
            if (sum % i == 0) {
                list.add(i);
                list.add(sum / i);
            }
        }
        Collections.sort(list);
        for (int[] e : edges) {
            map.putIfAbsent(e[0], new ArrayList<>());
            map.putIfAbsent(e[1], new ArrayList<>());
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        List<List<int[]>> level = new ArrayList<>();
        List<int[]> zero = new ArrayList<>();
        zero.add(new int[]{0, 0});
        Queue<Integer> que = new LinkedList<>();
        que.offer(0);
        while (!que.isEmpty()) {
            List<int[]> tmp = new ArrayList<>();
            for (int i = que.size(); i > 0; i--) {
                int p = que.poll();
                v[p] = true;
                for (int x : map.get(p)) {
                    if (v[x]) {
                        continue;
                    }
                    tmp.add(new int[]{x, p});
                    que.offer(x);
                }
            }
            if (tmp.size() != 0) {
                level.add(tmp);
            }
        }
        int ans = 0;
        for (Integer x : list) {
            int[] w = new int[n];
            System.arraycopy(nums, 0, w, 0, n);
            boolean flag = false;
            int t = 0;
            for (int i = level.size() - 1; i >= 0; i--) {
                for (int[] j : level.get(i)) {
                    if (w[j[0]] > x) {
                        flag = true;
                        break;
                    } else if (w[j[0]] == x) {
                        t++;
                    } else {
                        w[j[1]] += w[j[0]];
                    }
                }
                if (flag) {
                    break;
                }
            }
            if (flag) {
                continue;
            }
            ans = Math.max(ans, t);
            if (ans > 0) {
                return ans;
            }
        }
        return ans;
    }
}
