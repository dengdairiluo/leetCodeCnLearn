package com.yuren.leetcodecnlearn.Q1200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-11-06 22:44
 */
public class Q1131 {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        //消除绝对值，然后分成i位置和j位置两部分，进而求最大值，最小值
        //消除绝对值，得到四种情况，写出来，每种都可以分成i，j两部分，写出来就知道了
        int res = 0;
        int maxV = Integer.MIN_VALUE;
        int minV = Integer.MAX_VALUE;
        int len = arr1.length;
        for (int i = 0; i < len; i++) {
            if (arr1[i] + arr2[i] + i > maxV) {
                maxV = arr1[i] + arr2[i] + i;
            }
            if (arr1[i] + arr2[i] + i < minV) {
                minV = arr1[i] + arr2[i] + i;
            }
        }
        if (maxV - minV > res) {
            res = maxV - minV;
        }
        maxV = Integer.MIN_VALUE;
        minV = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int temp = arr1[i] - arr2[i] + i;
            if (temp > maxV) {
                maxV = temp;
            }
            if (temp < minV) {
                minV = temp;
            }
        }
        if (maxV - minV > res) {
            res = maxV - minV;
        }
        maxV = Integer.MIN_VALUE;
        minV = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int temp = arr2[i] - arr1[i] + i;
            if (temp > maxV) {
                maxV = temp;
            }
            if (temp < minV) {
                minV = temp;
            }
        }
        if (maxV - minV > res) {
            res = maxV - minV;
        }
        maxV = Integer.MIN_VALUE;
        minV = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int temp = arr1[i] + arr2[i] - i;
            if (temp > maxV) {
                maxV = temp;
            }
            if (temp < minV) {
                minV = temp;
            }
        }
        if (maxV - minV > res) {
            res = maxV - minV;
        }
        return res;
    }
}
