package com.yuren.leetcodecnlearn.Q2700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-11-16 03:07
 */
public class Q2784 {
    public boolean isGood(int[] nums) {
        int[] map = new int[201];
        for (int num : nums) {
            map[num]++;
        }
        int n = nums.length - 1;
        if (map[n] != 2) {
            return false;
        }
        for (int i = n - 1; i > 0; i--) {
            if (map[i] != 1) {
                return false;
            }
        }
        return true;
    }
}
