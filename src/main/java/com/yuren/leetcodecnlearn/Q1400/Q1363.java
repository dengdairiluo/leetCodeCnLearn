package com.yuren.leetcodecnlearn.Q1400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-02-09 23:52
 */
public class Q1363 {
    public String largestMultipleOfThree(int[] digits) {
        int[] buckets = new int[10];
        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            sum += digits[i];
            buckets[digits[i]]++;
        }
        sum %= 3;
        int rem1 = buckets[1] + buckets[4] + buckets[7];
        int rem2 = buckets[2] + buckets[5] + buckets[8];
        if (sum == 1) {
            if (rem1 > 0) {
                rem1--;
            } else {
                rem2 -= 2;
            }
        } else if (sum == 2) {
            if (rem2 > 0) {
                rem2--;
            } else {
                rem1 -= 2;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            if (i % 3 == 1) {
                while (rem1 > 0 && buckets[i] > 0) {
                    buckets[i]--;
                    rem1--;
                    res.append(i);
                }
            } else if (i % 3 == 2) {
                while (rem2 > 0 && buckets[i] > 0) {
                    buckets[i]--;
                    rem2--;
                    res.append(i);
                }
            } else {
                while (buckets[i] > 0) {
                    buckets[i]--;
                    res.append(i);
                }
            }
        }
        return res.length() > 0 && res.charAt(0) == '0' ? "0" : res.toString();
    }
}
