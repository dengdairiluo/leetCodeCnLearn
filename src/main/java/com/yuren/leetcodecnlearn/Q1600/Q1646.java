package com.yuren.leetcodecnlearn.Q1600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-05-30 23:45
 */
public class Q1646 {
    private static final int N = 110;
    private static final int[] NUMS = new int[N];

    static {
        NUMS[0] = 0;
        NUMS[1] = 1;
        for (int i = 0; i < N; i++) {
            if (2 * i < N) {
                NUMS[2 * i] = NUMS[i];
            }
            if (2 * i + 1 < N) {
                NUMS[2 * i + 1] = NUMS[i] + NUMS[i + 1];
            }
        }
        for (int i = 0, max = 0; i < N; i++) {
            NUMS[i] = max = Math.max(max, NUMS[i]);
        }
    }

    public int getMaximumGenerated(int n) {
        return NUMS[n];
    }
}
