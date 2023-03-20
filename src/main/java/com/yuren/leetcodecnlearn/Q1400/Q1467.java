package com.yuren.leetcodecnlearn.Q1400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-03-21 00:21
 */
public class Q1467 {
    double[] factorial;
    double[][][] memo;
    int[] balls;
    int sum;
    int n;

    public double getProbability(int[] balls) {
        this.balls = balls;
        n = balls.length;
        for (int v : balls) {
            sum += v;
        }
        factorial = new double[sum + 1];
        memo = new double[n][sum + 1][n * 2 + 1];
        factorial[0] = 1;
        for (int i = 1; i < factorial.length; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        return dfs(0, 0, n) / comb(sum, sum >> 1);
    }

    public double dfs(int pos, int cnt, int color) {
        if (pos == n) {
            return (cnt == sum >> 1 && color == n) ? 1 : 0;
        }
        if (memo[pos][cnt][color] != 0) {
            return memo[pos][cnt][color];
        }
        double ans = dfs(pos + 1, cnt, color - 1) + dfs(pos + 1, cnt + balls[pos], color + 1);
        for (int i = 1; i < balls[pos]; i++) {
            ans += dfs(pos + 1, cnt + i, color) * comb(balls[pos], i);
        }
        return memo[pos][cnt][color] = ans;
    }

    public double comb(int x, int y) {
        return (factorial[x] / factorial[y] / factorial[x - y]);
    }
}
