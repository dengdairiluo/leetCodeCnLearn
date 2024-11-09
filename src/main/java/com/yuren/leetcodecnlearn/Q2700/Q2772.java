package com.yuren.leetcodecnlearn.Q2700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-11-10 02:51
 */
public class Q2772 {
    public boolean checkArray(int[] nums, int k) {
        int n = nums.length, sumD = 0;
        var d = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sumD += d[i];
            int x = nums[i];
            x += sumD;
            if (x == 0) continue; // 无需操作
            if (x < 0 || i + k > n) return false; // 无法操作
            sumD -= x; // 直接加到 sumD 中
            d[i + k] += x;
        }
        return true;
    }
}
