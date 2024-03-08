package com.yuren.leetcodecnlearn.Q2200;

import java.util.Stack;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-03-08 21:37
 */
public class Q2282 {
    public int[][] seePeople(int[][] heights) {
        int n = heights.length, m = heights[0].length;
        int[][] ans = new int[n][m];

        for (int i = 0; i < n; i++) {
            Stack<Integer> stack = new Stack<>();
            for (int j = m - 1; j >= 0; j--) {
                int pre = -1;
                while (!stack.isEmpty() && heights[i][stack.peek()] < heights[i][j]) {
                    int k = stack.pop();
                    if (!stack.isEmpty()) {
                        ans[i][k]++;
                    }
                    if (heights[i][k] != pre) {
                        ans[i][j]++;
                    }
                    pre = heights[i][k];
                }
                stack.add(j);
            }
            while (!stack.isEmpty()) {
                int k = stack.pop();
                if (!stack.isEmpty()) {
                    ans[i][k]++;
                }
            }
        }

        for (int j = 0; j < m; j++) {
            Stack<Integer> stack = new Stack<>();
            for (int i = n - 1; i >= 0; i--) {
                int pre = -1;
                while (!stack.isEmpty() && heights[stack.peek()][j] < heights[i][j]) {
                    int k = stack.pop();
                    if (!stack.isEmpty()) {
                        ans[k][j]++;
                    }
                    if (heights[k][j] != pre) {
                        ans[i][j]++;
                    }
                    pre = heights[k][j];
                }
                stack.add(i);
            }
            while (!stack.isEmpty()) {
                int k = stack.pop();
                if (!stack.isEmpty()) {
                    ans[k][j]++;
                }
            }
        }

        return ans;
    }
}
