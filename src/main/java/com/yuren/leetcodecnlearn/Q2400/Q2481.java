package com.yuren.leetcodecnlearn.Q2400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-06-16 下午10:26
 */
public class Q2481 {
    public int numberOfCuts(int n) {
        return n > 1 && n % 2 == 1 ? n : n >> 1;
    }
}
