package com.yuren.leetcodecnlearn.Q2500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-07-03 下午11:43
 */
public class Q2515 {
    public int closetTarget(String[] w, String t, int s) {
        int n = w.length;
        for (int step = 0, l = s, r = s; step < n; l = (--l + n) % n, r = ++r % n, step++)
            if (w[l].equals(t) || w[r].equals(t)) return step;
        return -1;
    }
}
