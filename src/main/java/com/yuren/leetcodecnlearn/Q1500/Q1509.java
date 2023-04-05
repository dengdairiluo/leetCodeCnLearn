package com.yuren.leetcodecnlearn.Q1500;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-04-06 00:37
 */
public class Q1509 {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if (n <= 4) {
            return 0;
        }

        int[] maxn = new int[4];
        int[] minn = new int[4];
        Arrays.fill(maxn, -1000000000);
        Arrays.fill(minn, 1000000000);
        for (int num : nums) {
            int add = 0;
            while (add < 4 && maxn[add] > num) {
                add++;
            }
            if (add < 4) {
                for (int j = 3; j > add; j--) {
                    maxn[j] = maxn[j - 1];
                }
                maxn[add] = num;
            }
            add = 0;
            while (add < 4 && minn[add] < num) {
                add++;
            }
            if (add < 4) {
                for (int j = 3; j > add; j--) {
                    minn[j] = minn[j - 1];
                }
                minn[add] = num;
            }
        }
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            ret = Math.min(ret, maxn[i] - minn[3 - i]);
        }
        return ret;
    }
}
