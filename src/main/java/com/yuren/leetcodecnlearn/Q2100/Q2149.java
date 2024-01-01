package com.yuren.leetcodecnlearn.Q2100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-01-01 22:51
 */
public class Q2149 {
    public int[] rearrangeArray(int[] nums) {
        int pst = 0;
        int ngt = 1;
        int[] ret = new int[nums.length];
        for (int num : nums) {
            if (num > 0) {
                ret[pst] = num;
                pst += 2;
            } else {
                ret[ngt] = num;
                ngt += 2;
            }
        }
        return ret;
    }
}
