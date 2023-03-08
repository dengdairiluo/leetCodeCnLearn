package com.yuren.leetcodecnlearn.Q1100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-11-07 23:47
 */
public class Q1133 {
    public int largestUniqueNumber(int[] nums) {
        int[] r = new int[1001];
        for (int num : nums) {
            r[num]++;
        }
        for (int i = 1000; i >= 0; i--) {
            if (r[i] == 1) {
                return i;
            }
        }
        return -1;
    }
}
