package com.yuren.leetcodecnlearn.Q1500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-04-27 00:34
 */
public class Q1558 {
    public int minOperations(int[] nums) {
        int res = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            res += Integer.bitCount(n);
            max = Math.max(max, n);
        }
        int c = 0;
        while (max != 0) {
            max >>= 1;
            c++;
        }
        c = Math.max(0, c - 1);
        res += c;
        return res;
    }
}
