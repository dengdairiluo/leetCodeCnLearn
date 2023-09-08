package com.yuren.leetcodecnlearn.Q1900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-09-07 23:54
 */
public class Q1908 {
    public boolean nimGame(int[] piles) {
        int n = 0;
        for (int i : piles) {
            n = n ^ i;
        }
        return n != 0;
    }
}
