package com.yuren.leetcodecnlearn.Q2500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-08-06 下午11:14
 */
public class Q2582 {
    public int passThePillow(int n, int time) {
        int t = time % (n - 1);
        return time / (n - 1) % 2 > 0 ? n - t : 1 + t;
    }
}
