package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-09-05 23:57
 */
public class Q974 {
    public int subArraysDivByK(int[] nums, int k) {
        int n = nums.length, sum = 0, ans = 0;
        int[] map = new int[k];
        map[0] = 1;
        for (int i = 1; i <= n; i++) {
            sum = sum + nums[i - 1];
            int key = (sum % k + k) % k;
            ans += map[key];
            map[key]++;
        }
        return ans;
    }
}
