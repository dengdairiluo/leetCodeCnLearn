package com.yuren.leetcodecnlearn.Q1900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-09-24 23:36
 */
public class Q1950 {
    public int[] findMaximums(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] stack = new int[n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            while (cnt != 0 && nums[stack[cnt - 1]] >= nums[i]) {
                int j = stack[--cnt];
                int left = cnt == 0 ? -1 : stack[cnt - 1];
                int len = i - left - 1;
                ans[len - 1] = Math.max(ans[len - 1], nums[j]);
            }
            stack[cnt++] = i;
        }
        while (cnt != 0) {
            int j = stack[--cnt];
            int left = cnt == 0 ? -1 : stack[cnt - 1];
            int len = n - left - 1;
            ans[len - 1] = Math.max(ans[len - 1], nums[j]);
        }
        for (int i = n - 2; i > 0; i--) {
            if (ans[i] < ans[i + 1]) {
                ans[i] = ans[i + 1];
            }
        }
        return ans;
    }
}
