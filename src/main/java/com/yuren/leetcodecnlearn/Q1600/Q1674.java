package com.yuren.leetcodecnlearn.Q1600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-06-10 23:49
 */
public class Q1674 {
    public int minMoves(int[] nums, int limit) {
        int[] arr = new int[(limit << 1) + 2];
        int n = nums.length;
        for (int i = 0; i < (n >> 1); i++) {
            int num1 = nums[i], num2 = nums[n - 1 - i];
            int min = Math.min(num1, num2);
            int max = Math.max(num1, num2);
            int sum = num1 + num2;
            arr[1] += 2;
            arr[min + 1] -= 1;
            arr[max + limit + 1] += 1;
            arr[sum] -= 1;
            arr[sum + 1] += 1;
        }
        int ans = Integer.MAX_VALUE, sum = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            sum += arr[i];
            ans = Math.min(ans, sum);
        }
        return ans;
    }
}
