package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-08-01 23:14
 */
public class Q902 {
    public int atMostNGivenDigitSet(String[] d, int n) {
        int[] array = new int[d.length];
        for (int i = 0; i < d.length; i++) {
            array[i] = Integer.parseInt(d[i]);
        }
        int result = 0;
        int a = n;
        int index = 0;
        while (a >= 10) {
            a /= 10;
            index++;
            result += (int) Math.pow(d.length, index);
        }
        // 以上是得到少位的数量总和
        result = get(result, array, n, index);
        return result;
    }

    // result 总数量 array 数字数组  N 当前位数的最大值  index 当前的N/10能得多少
    public int get(int result, int[] array, int N, int index) {
        int minIndex = 0;
        boolean equ = false;
        if (N < 10) {
            for (int j : array) {
                if (j <= N) {
                    result++;
                }
            }
            return result;
        }
        for (int j : array) {
            if (j == N / (int) Math.pow(10, index)) {
                equ = true;
            }
            if (j < N / (int) Math.pow(10, index)) {
                minIndex++;
            }
        }
        result += minIndex * (int) Math.pow(array.length, index);
        if (equ) {
            result = get(result, array, N % ((int) Math.pow(10, index)), index - 1);
        }
        return result;
    }
}
