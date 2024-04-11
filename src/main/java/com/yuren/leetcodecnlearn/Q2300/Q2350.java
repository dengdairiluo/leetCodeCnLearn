package com.yuren.leetcodecnlearn.Q2300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-04-11 下午11:37
 */
public class Q2350 {
    public int shortestSequence(int[] rolls, int k) {
        // mark[v] 标记 v 属于哪个子段
        int[] mark = new int[k + 1];
        int ans = 1, left = k;
        for (int v : rolls)
            if (mark[v] < ans) {
                mark[v] = ans;
                if (--left == 0) {
                    left = k;
                    ++ans;
                }
            }
        return ans;
    }
}
