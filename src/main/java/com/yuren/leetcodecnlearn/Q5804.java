package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-07-25 22:47
 */
public class Q5804 {

    public boolean areOccurrencesEqual(String s) {
        int n = s.length();

        int[] c1 = new int[26];
        for (int i = 0; i < n; i++) {
            ++c1[s.charAt(i) - 'a'];
        }

        int right = c1.length - 1, left = 0;
        while (left < right) {
            if (c1[left] == 0) {
                ++left;
            } else if (c1[right] == 0) {
                --right;
            } else {

                if (c1[left] == c1[right]) {
                    ++left;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
