package com.yuren.leetcodecnlearn.Q2100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-01-26 23:37
 */
public class Q2198 {
    public long singleDivisorTriplet(int[] nums) {
        int[] cnts = new int[101];
        for (int num : nums) {
            cnts[num]++;
        }

        long res = 0;
        for (int i = 1; i <= 100; ++i) {
            for (int j = i; j <= 100; ++j) {
                for (int k = j; k <= 100; ++k) {
                    int s = i + j + k;
                    if (((s % i == 0) ? 1 : 0) + ((s % j == 0) ? 1 : 0) + ((s % k == 0) ? 1 : 0) == 1) {
                        if (i != j && j != k) {
                            res += 6L * cnts[i] * cnts[j] * cnts[k];
                        } else if (i == j) {
                            res += 3L * cnts[i] * (cnts[i] - 1) * cnts[k];
                        } else {
                            res += 3L * cnts[i] * cnts[j] * (cnts[j] - 1);
                        }
                    }
                }
            }
        }

        return res;

    }
}
