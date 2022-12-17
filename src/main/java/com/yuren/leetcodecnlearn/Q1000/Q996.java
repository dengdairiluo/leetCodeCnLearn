package com.yuren.leetcodecnlearn.Q1000;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-09-11 23:54
 */
public class Q996 {
    int res = 0;

    public int numSquarefulPerms(int[] A) {
        // 排序是剪枝2的前提
        Arrays.sort(A);
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] visited = new boolean[A.length];
        backtrack(A, visited, track);
        return res;
    }

    public void backtrack(int[] nums, boolean[] visited, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            res++;
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 剪枝1
            if (visited[i]) {
                continue;
            }
            // 剪枝2
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            // 剪枝3
            if (!track.isEmpty() && !isSquare(track.getLast(), nums[i])) {
                continue;
            }
            track.add(nums[i]);
            visited[i] = true;
            backtrack(nums, visited, track);
            visited[i] = false;
            track.pollLast();
        }
    }

    /**
     * 判断a+b之和是不是一个完全平方数
     *
     * @param a
     * @param b
     * @return
     */
    public boolean isSquare(int a, int b) {
        int tmp = a + b;
        int sq = (int) Math.sqrt(tmp);
        return sq * sq == tmp;
    }

}
