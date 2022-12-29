package com.yuren.leetcodecnlearn.Q1900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-07-11 22:32
 */
public class Q1852 {
    public int[] distinctNumbers(int[] nums, int k) {
        int n = nums.length, size = 0;
        int[] aux = new int[100_001];
        for (int i = 0; i < k; i++) {
            if (aux[nums[i]] == 0) {
                size++;
            }
            aux[nums[i]]++;
        }
        int[] ans = new int[n - k + 1];
        ans[0] = size;
        for (int j = k, i = 0; j < n; j++) {
            if (aux[nums[j]]++ == 0) {
                size++;
            }
            if (--aux[nums[i]] == 0) {
                size--;
            }
            ans[++i] = size;
        }
        return ans;
    }
}
