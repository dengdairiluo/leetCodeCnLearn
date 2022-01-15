package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-01-15 23:36
 */
public class Q453 {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(num, min);
        }
        int ans = 0;
        for (int num : nums) {
            ans += num - min;
        }
        return ans;
    }
}
