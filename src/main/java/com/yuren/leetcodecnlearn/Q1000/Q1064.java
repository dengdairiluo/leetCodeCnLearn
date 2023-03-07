package com.yuren.leetcodecnlearn.Q1000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-10-09 23:26
 */
public class Q1064 {
    public int fixedPoint(int[] arr) {
        for (int i = 0, len = arr.length; i < len; i++) {
            if (arr[i] == i) {
                return i;
            }
        }
        return -1;

    }
}
