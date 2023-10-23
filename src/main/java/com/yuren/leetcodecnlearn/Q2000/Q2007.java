package com.yuren.leetcodecnlearn.Q2000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-10-23 23:18
 */
public class Q2007 {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        int max = 0;

        for (int value : changed) {
            max = Math.max(max, value);
        }

        int[] sorted = new int[max + 1];

        for (int k : changed) {
            sorted[k]++;
        }

        int[] ans = new int[n / 2];
        int itr = 0;

        if (sorted[0] % 2 == 1)
            return new int[0];

        for (int i = 1; i <= max; i++) {
            if (sorted[i] > 0) {
                if (2 * i > max || sorted[i] > sorted[2 * i])
                    return new int[0];
                else {
                    sorted[2 * i] -= sorted[i];
                    for (int j = 1; j <= sorted[i]; j++)
                        ans[itr++] = i;
                }
            }
        }

        return ans;

    }
}
