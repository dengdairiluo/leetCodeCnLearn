package com.yuren.leetcodecnlearn.Q1500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-03-06 23:49
 */
public class Q1433 {
    public boolean checkIfCanBreak(String s1, String s2) {
        int[] b1 = new int[128];
        int[] b2 = new int[128];
        for (char ch : s1.toCharArray()) {
            b1[ch]++;
        }

        for (char ch : s2.toCharArray()) {
            b2[ch]++;
        }

        for (int i = 'b'; i <= 'z'; i++) {
            b1[i] = b1[i] + b1[i - 1];
            b2[i] = b2[i] + b2[i - 1];
        }

        boolean flg1 = true;
        boolean flg2 = true;
        for (int i = 'a'; i <= 'z'; i++) {
            if (b1[i] < b2[i]) {
                flg1 = false;
            }

            if (b1[i] > b2[i]) {
                flg2 = false;
            }
        }

        return flg1 || flg2;
    }
}
