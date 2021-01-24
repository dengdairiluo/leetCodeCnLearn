package com.yuren.leetcodecnlearn;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-01-24 18:13
 */
public class Q5645 {

    public static int largestAltitude(int[] gain) {
        int max = 0;
        int cur = 0;
        for (int c : gain) {
            cur += c;
            max = Math.max(cur, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] gain = new int[] {-4, -3, -2, -1, 4, 3, 2};
        System.out.println(largestAltitude(gain));
    }
}
