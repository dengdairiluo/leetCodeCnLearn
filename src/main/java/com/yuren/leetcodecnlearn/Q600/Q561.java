package com.yuren.leetcodecnlearn.Q600;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-04-11 23:25
 */
public class Q561 {

    public int arrayPairSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < n; i += 2) {
            ans += nums[i];
        }
        return ans;
    }

}
