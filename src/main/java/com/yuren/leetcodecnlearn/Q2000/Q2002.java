package com.yuren.leetcodecnlearn.Q2000;

/**
 * Created with Intellij IDEA.
 * Description:
 * 题解：见方法 2.
 * https:leetcode.cn/problems/maximum-product-of-the-length-of-two-palindromic-subsequences/solution/mei-ju-dong-tai-gui-hua-jian-zhi-by-ling-r8ls/
 * Fatal (1):
 * 太妙了!!! [两个不相交的子序列] 的最快的判断方式是，用二进制表示!!! 然后 (s1 & s2) == 0 即可!!! 妙啊!!!
 * O(1) 就能判断!!! 前提是 s.length <= 32 就是了.
 * <p>
 * Note:
 * 二进制 DP. 且 "回文子序列" 的题是 $516!!! 我都不会做了.
 * <p>
 * s.length <= 12. 可以二进制 DP.
 * 先有个回文子序列 DP，用来快速判断一个状态 s 构成的子序列的最长 palindrome 长度.
 * DP[s]: DP[] 方程框架和 $516 一模一样. 只不过，s 是一个状态. 所以需要遍历 l 和 r 之间的 [所有] 状态，并转移到当前状态上.
 *
 * @author lujiang
 * @date 2023-10-23 23:09
 */
public class Q2002 {
    /**
     * @param str
     * @return
     */
    public int maxProduct(String str) {

        char[] chars = str.toCharArray();
        final int n = chars.length;
        int[] dp = new int[1 << n];
        // process.
        for (int l = n - 1; l >= 0; l--) {
            for (int r = l; r < n; r++) {

                if (l == r) {
                    // max 回文子序列的长度为 1.
                    dp[1 << (n - l - 1)] = 1;
                    continue;
                } else if (l + 1 == r && chars[l] == chars[r]) {
                    // max 回文子序列的长度为 2.
                    dp[(1 << (n - l - 1)) | (1 << (n - r - 1))] = 2;
                    continue;
                }

                if (chars[l] == chars[r]) {
                    // 为 [l+1, r-1] 这个子数组内部的所有状态 s、加上 l 和 r 两个点的状态赋值.
                    //
                    // for prevS in [[l+1, r-1] 的所有状态]:  // 共 2^((r-1)-(l+1)+1) 个状态 == 2^(r-l-1)
                    //   s = prevS | (1<<(n-l-1)) | (1<<(n-r-1))
                    //   DP[s] = MAX(DP[s], DP[prevS] + 2);
                    for (int k = 0; k < (1 << (r - l - 1)); k++) {
                        final int prevS = k << ((n - 1) - r + 1);   // index [r, n-1] 之间的数位都填 0.
                        final int s = prevS | (1 << (n - l - 1)) | (1 << (n - r - 1));
                        dp[s] = Math.max(dp[s], dp[prevS] + 2);
                    }
                } else {
                    // 为 [l+1, r-1] 这个子数组内部的所有状态 s、加上 l 和 r 两个点的状态赋值.
                    //
                    // for prevS in [[l+1, r-1] 的所有状态]:  // 同上.
                    //   s1 = prevS | (1<<(n-l-1))
                    //   s2 = prevS | (1<<(n-r-1))
                    //   s  = prevS | (1<<(n-l-1)) | (1<<(n-r-1))
                    //   DP[s] = MAX(DP[s], DP[s1], DP[s2]);
                    for (int k = 0; k < (1 << (r - l - 1)); k++) {
                        final int prevS = k << ((n - 1) - r + 1);   // index [r, n-1] 之间的数位都填 0.
                        final int s1 = prevS | (1 << (n - l - 1));
                        final int s2 = prevS | (1 << (n - r - 1));
                        final int s = prevS | (1 << (n - l - 1)) | (1 << (n - r - 1));
                        dp[s] = Math.max(dp[s], Math.max(dp[s1], dp[s2]));
                    }
                }
            }
        }

        // 枚举.
        int max = 0;
        // 枚举第一个子序列的状态 s1. 这个子序列一定是 s1 之中的某一个了.
        for (int s1 = 1 /* 从 1 开始：不可以是空集 */; s1 < (1 << n); s1++) {
            // 剩下的就是另一个子序列依赖的状态 s2. 这个子序列一定是 s2 之中的某一个了.
            final int s2 = ((1 << n) - 1) ^ s1;

            // Fatal:
            //  答案为：(s1 状态中的最长回文子序列长度) * (不相交的 s2 状态中的最长回文子序列长度)!!!
            max = Math.max(max, dp[s1] * dp[s2]);
        }
        return max;
    }
}
