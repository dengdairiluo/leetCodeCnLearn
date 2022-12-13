package com.yuren.leetcodecnlearn;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-12-13 23:54
 */
public class Q1215 {
    // BFS
    public List<Integer> countSteppingNumbersBFS(int low, int high) {
        List<Integer> res = new ArrayList<>();
        if (low == 0) {
            res.add(0);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= 9; i++) {
            queue.add(i);
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur >= low && cur <= high) {
                res.add(cur);
            }
            // 越界剪枝，因为后面要乘以10
            if (cur > Integer.MAX_VALUE / 10) {
                continue;
            }

            int tail = cur % 10;

            int right = cur * 10 + tail + 1;
            int left = cur * 10 + tail - 1;
            if (tail + 1 <= 9 && right <= high) {
                queue.add(right);
            }

            if (tail - 1 >= 0 && left <= high) {
                queue.add(left);
            }
        }

        Collections.sort(res);
        return res;
    }

    // DFS
    public List<Integer> countSteppingNumbers(int low, int high) {
        List<Integer> res = new ArrayList<>();

        if (low == 0) {
            res.add(0);
        }

        for (int i = 1; i <= 9; i++) {
            dfs(res, i, low, high);
        }

        Collections.sort(res);
        return res;
    }

    private void dfs(List<Integer> list, int cur, int low, int high) {

        if (cur >= low && cur <= high) {
            list.add(cur);
        }

        if (cur > Integer.MAX_VALUE / 10) {
            return;
        }


        int tail = cur % 10;
        if (tail - 1 >= 0) {
            dfs(list, cur * 10 + tail - 1, low, high);
        }

        if (tail + 1 <= 9) {
            dfs(list, cur * 10 + tail + 1, low, high);
        }
    }

}
