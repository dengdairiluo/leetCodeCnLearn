package com.yuren.leetcodecnlearn;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-12-06 23:17
 */
public class Q1196 {
    public int maxNumberOfApples(int[] arr) {
        Arrays.sort(arr);
        int sum = 0;
        int count = 0;
        for (int j : arr) {
            sum += j;
            if (sum > 5000) {
                break;
            }
            count++;
        }
        return count;
    }
}
