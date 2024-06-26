package com.yuren.leetcodecnlearn.Q2400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-06-08 下午11:56
 */
public class Q2459 {

    public int sortArray(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = (nums[i] - 1 + n) % n;
        }
        int a = f(nums, 0);
        int b = f(arr, n - 1);
        return Math.min(a, b);
    }

    private int f(int[] nums, int k) {
        boolean[] vis = new boolean[nums.length];
        int cnt = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i == nums[i] || vis[i]) {
                continue;
            }
            ++cnt;
            int j = nums[i];
            while (!vis[j]) {
                vis[j] = true;
                ++cnt;
                j = nums[j];
            }
        }
        if (nums[k] != k) {
            cnt -= 2;
        }
        return cnt;
    }
}
