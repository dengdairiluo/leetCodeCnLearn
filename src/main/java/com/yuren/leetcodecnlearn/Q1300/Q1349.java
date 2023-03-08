package com.yuren.leetcodecnlearn.Q1300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-02-06 23:49
 */
public class Q1349 {
    public int maxStudents(char[][] seats) {
        int m = seats.length;
        int n = seats[0].length;
        int mask = 1 << n;
        // dp[i][j] 表示第 j 排（下标从 1 开始）的座位分配位掩码为 i 时的最大学生数
        int[][] dp = new int[mask][m + 1];
        int res = 0;
        // 模拟从第一排向第 m 排分配座位的过程
        for (int i = 1; i <= m; i++) {
            // invalid 记录当前行的破坏座位情况
            int invalid = 0;
            for (int j = 0; j < n; j++) {
                if (seats[i - 1][j] == '#') {
                    invalid |= 1 << j;
                }
            }
            // 枚举当前行的分配情况
            for (int k = 0; k < mask; k++) {
                // 两种情况导致分配不合法：1、分配在了坏的座位上：k & invalid 的某一位不是 0；2、分配出现了相邻的情况（比较同行只需要枚举 k & (k << 1) 即可，因为整数范围大于 n 位，k & (k << 1) 包含了 k && (k >>> 1) 的信息）
                if ((k & invalid) != 0 || (k & (k << 1)) != 0) {
                    // 将当前状态标记为 -1，代表状态不合法
                    dp[k][i] = -1;
                    continue;
                }
                // 再枚举前一排的情况
                for (int s = 0; s < mask; s++) {
                    // 三种情况导致分配不合法：1、状态 s 不合法，dp[s][i - 1] 已经被标记为 -1；2、右前方有人：k & (s >>> 1) != 0；3、左前方有人：k & (s << 1) != 0
                    if (dp[s][i - 1] == -1 || (k & (s << 1)) != 0 || (k & (s >>> 1)) != 0) {
                        continue;
                    }
                    // 递推 dp[k][i]，并更新最大值
                    dp[k][i] = Math.max(dp[k][i], dp[s][i - 1] + Integer.bitCount(k));
                    res = Math.max(res, dp[k][i]);
                }
            }
        }
        return res;
    }
}
