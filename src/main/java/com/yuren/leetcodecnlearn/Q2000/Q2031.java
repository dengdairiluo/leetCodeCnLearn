package com.yuren.leetcodecnlearn.Q2000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-11-03 23:47
 */
public class Q2031 {
    public int subarraysWithMoreZerosThanOnes(int[] nums) {
        int base = 1000000007;
        int n = nums.length;
        int res = 0;
        int[] cnts = new int[2 * n + 1];
        cnts[n] = 1;
        for (int i = 0, s = n, cnt = 0; i < n; i++) {
            if (nums[i] == 0) {
                cnt -= cnts[--s];
            } else {
                cnt += cnts[s++];
            }
            cnts[s]++;
            res = (res + cnt) % base;
        }
        return res;
    }
}
