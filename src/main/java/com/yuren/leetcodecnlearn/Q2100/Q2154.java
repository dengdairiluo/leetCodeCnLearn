package com.yuren.leetcodecnlearn.Q2100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-01-04 23:45
 */
public class Q2154 {
    public int findFinalValue(int[] nums, int original) {
        int[] cnt = new int[1001];
        for (int num : nums) {
            cnt[num]++;
        }

        while (original < 1001 && cnt[original] != 0) {
            original *= 2;
        }
        return original;


    }
}
