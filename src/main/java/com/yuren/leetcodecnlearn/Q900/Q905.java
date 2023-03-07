package com.yuren.leetcodecnlearn.Q900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-06-05 22:48
 */
public class Q905 {
    public int[] sortArrayByParity(int[] nums) {
        int[] ans = new int[nums.length];
        int t = 0;

        for (int j : nums) {
            if (j % 2 == 0) {
                ans[t++] = j;
            }
        }

        for (int num : nums) {
            if (num % 2 == 1) {
                ans[t++] = num;
            }
        }

        return ans;
    }
}
