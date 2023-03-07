package com.yuren.leetcodecnlearn.Q900;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-08-20 23:52
 */
public class Q945 {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int pre = nums[0] - 1, ans = 0;
        for (int i : nums) {
            if (i > pre) {
                pre = i;
            } else {
                ans += ++pre - i;
            }
        }
        return ans;
    }
}
