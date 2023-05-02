package com.yuren.leetcodecnlearn.Q1500;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-05-02 23:00
 */
public class Q1575 {
    private static final int MOD = 1000000007;

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        int startPos = locations[start];
        int finishPos = locations[finish];
        Arrays.sort(locations);
        for (int i = 0; i < n; ++i) {
            if (startPos == locations[i]) {
                start = i;
            }
            if (finishPos == locations[i]) {
                finish = i;
            }
        }

        int[][] dpL = new int[n][fuel + 1];
        int[][] dpR = new int[n][fuel + 1];
        dpL[start][0] = dpR[start][0] = 1;

        for (int used = 0; used <= fuel; ++used) {
            for (int city = n - 2; city >= 0; --city) {
                int delta = locations[city + 1] - locations[city];
                if (used >= delta) {
                    dpL[city][used] = ((used == delta ? 0 : dpL[city + 1][used - delta]) * 2 % MOD + dpR[city + 1][used - delta]) % MOD;
                }
            }
            for (int city = 1; city < n; ++city) {
                int delta = locations[city] - locations[city - 1];
                if (used >= delta) {
                    dpR[city][used] = ((used == delta ? 0 : dpR[city - 1][used - delta]) * 2 % MOD + dpL[city - 1][used - delta]) % MOD;
                }
            }
        }

        int ans = 0;
        for (int used = 0; used <= fuel; ++used) {
            ans += (dpL[finish][used] + dpR[finish][used]) % MOD;
            ans %= MOD;
        }
        if (start == finish) {
            ans = (ans + MOD - 1) % MOD;
        }
        return ans;
    }
}
