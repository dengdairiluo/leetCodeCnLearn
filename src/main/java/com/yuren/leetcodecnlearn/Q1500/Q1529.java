package com.yuren.leetcodecnlearn.Q1500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-04-15 23:22
 */
public class Q1529 {
    public int minFlips(String target) {
        int flips = 0;
        char prev = '0';
        int n = target.length();
        for (int i = 0; i < n; i++) {
            char curr = target.charAt(i);
            if (curr != prev) {
                flips++;
                prev = curr;
            }
        }
        return flips;
    }
}
