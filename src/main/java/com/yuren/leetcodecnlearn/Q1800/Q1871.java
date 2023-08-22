package com.yuren.leetcodecnlearn.Q1800;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-08-22 23:20
 */
public class Q1871 {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        char[] cs = s.toCharArray();
        if (cs[n - 1] != '0') {
            return false;
        }

        boolean[] dp = new boolean[n];
        dp[0] = true;
        int r = 0;
        for (int i = 0; i < n; i++) {
            if (!dp[i]) {
                continue;
            }

            int nextL = Math.max(r + 1, i + minJump);
            if (nextL >= n) {
                break;
            }

            int nextR = i + maxJump < n ? i + maxJump : n - 1;

            for (int j = nextL; j <= nextR; j++) {
                dp[j] = cs[j] == '0';
            }
            r = nextR;

        }

        return dp[n - 1];

    }
}
