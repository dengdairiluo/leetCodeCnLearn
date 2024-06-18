package com.yuren.leetcodecnlearn.Q2400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-06-18 下午11:44
 */
public class Q2485 {
    public int pivotInteger(int n) {
        int m = n * (n + 1) / 2;
        int x = (int) Math.sqrt(m);
        return x * x == m ? x : -1;
    }
}
