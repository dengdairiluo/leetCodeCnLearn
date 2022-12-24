package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-12-25 02:19
 */
public class Q1230 {
    public double probabilityOfHeads(double[] prob, int k) {
        int N = prob.length;
        if (k < 0 || k > N) {
            return 0;
        }
        if (k + k > N) {
            k = N - k;
            for (int i = 0; i < N; i++) {
                prob[i] = 1 - prob[i];
            }
        }
        if (k == 0) {
            double p = 1.0;
            for (double x : prob) {
                p *= (1 - x);
            }
            return p;
        }
        double[] dp = new double[k + 1];
        dp[0] = 1.0;
        int mk = 0;
        for (double x : prob) {
            if (mk < k) {
                mk++;
            }
            //dp[k] = dp0[k] * (1-x) + dp0[k-1] * x;
            for (int i = mk; i > 0; i--) {
                dp[i] = dp[i] * (1 - x) + dp[i - 1] * x;
            }
            dp[0] *= 1 - x;
        }
        return dp[k];
    }
}
