package com.yuren.leetcodecnlearn.Q2400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-05-14 上午12:14
 */
public class Q2411 {
    public int[] smallestSubarrays(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            res[i] = 1;
            for (int j = i - 1; j >= 0; --j) {
                if ((nums[j] | nums[i]) != nums[j]) {
                    nums[j] = (nums[j] | nums[i]);
                    res[j] = i - j + 1;
                } else break;
            }
        }
        return res;
    }
}
