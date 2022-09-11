package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-09-11 23:52
 */
public class Q995 {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        int ans = 0;
        int revCnt = 0;
        for (int i = 0; i < n; ++i) {
            revCnt ^= diff[i];
            // nums[i] ^ revCnt == 0
            if (nums[i] == revCnt) {
                if (i + k > n) {
                    return -1;
                }
                ++ans;
                revCnt ^= 1;
                diff[i + k] ^= 1;
            }
        }
        return ans;
    }
}
