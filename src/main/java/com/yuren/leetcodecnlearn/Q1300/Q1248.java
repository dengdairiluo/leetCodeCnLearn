package com.yuren.leetcodecnlearn.Q1300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-12-29 23:43
 */
public class Q1248 {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] odd = new int[n + 2];
        int ans = 0, cnt = 0;
        for (int i = 0; i < n; ++i) {
            if ((nums[i] & 1) != 0) {
                odd[++cnt] = i;
            }
        }
        odd[0] = -1;
        odd[++cnt] = n;
        for (int i = 1; i + k <= cnt; ++i) {
            ans += (odd[i] - odd[i - 1]) * (odd[i + k] - odd[i + k - 1]);
        }
        return ans;
    }
}
