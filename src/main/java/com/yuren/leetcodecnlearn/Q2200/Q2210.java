package com.yuren.leetcodecnlearn.Q2200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-02-01 23:17
 */
public class Q2210 {
    public int countHillValley(int[] nums) {
        int flag = 0;
        int ret = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                if (flag == 1) ret++;
                flag = 2;
            } else if (nums[i] < nums[i - 1]) {
                if (flag == 2) ret++;
                flag = 1;
            }
        }
        return ret;
    }
}
