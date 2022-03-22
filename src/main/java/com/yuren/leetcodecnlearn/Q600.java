package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-03-22 23:34
 */
public class Q600 {
    static int N = 50;
    // f[i][j] 为考虑二进制长度为 i，而且最高位为 j（0 or 1）时的合法数个数（值不超过）
    // 如 f[2][1] 代表二进制长度为 2，且（值不超过）最高位为 1 的合法数的个数为 3 个：10、01、00
    static int[][] f = new int[N][2];

    static {
        f[1][0] = 1;
        f[1][1] = 2;
        for (int i = 1; i < N - 1; i++) {
            f[i + 1][0] = f[i][1];
            f[i + 1][1] = f[i][0] + f[i][1];
        }
    }

    int getLen(int n) {
        for (int i = 31; i >= 0; i--) {
            if (((n >> i) & 1) == 1) {
                return i;
            }
        }
        return 0;
    }

    public int findIntegers(int n) {
        int len = getLen(n);
        int ans = 0, prev = 0;
        for (int i = len; i >= 0; i--) {
            // 当前位是 0 还是 1
            int cur = ((n >> i) & 1);
            // 由于始终要满足小于等于的要求，如果当前位本来为 1 的话，填成 0 的话，后面的低位无论怎么填，都是满足小于等于的要求的，因此将 f[i + 1][0] 累加到答案
            if (cur == 1) {
                ans += f[i + 1][0];
            }
            // 出现连续位为 1，分支结束，方案数被计算完
            if (prev == 1 && cur == 1) {
                break;
            }
            prev = cur;
            if (i == 0) {
                ans++;
            }
        }
        return ans;
    }
}
