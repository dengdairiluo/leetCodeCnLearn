package com.yuren.leetcodecnlearn.Q1100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-10-05 23:39
 */
public class Q1055 {
    public int shortestWay(String source, String target) {
        int sLen = source.length();
        int tLen = target.length();

        // 1. 预处理(因为步骤2是倒着动态规划的，最后一个slen需要处理)
        int[][] f = new int[sLen + 1][26];
        for (int i = 0; i < 26; ++i) {
            f[sLen][i] = sLen;
        }
        // 2. 计算每个字符在 source第一次出现的位置
        for (int i = sLen - 1; i >= 0; --i) {
            for (int j = 0; j < 26; ++j) {
                if (source.charAt(i) == (j + 'a')) {
                    f[i][j] = i;
                } else {
                    f[i][j] = f[i + 1][j];
                }
            }
        }
        // 3. 贪心的计算匹配次数
        int count = 0;
        int ti = 0;
        while (ti < tLen) {
            ++count;
            // 从头source的0位置开始重新匹配
            int startPos = 0;
            if (f[startPos][target.charAt(ti) - 'a'] == sLen) {
                return -1;
            }
            while (ti < tLen && f[startPos][target.charAt(ti) - 'a'] != sLen) {
                startPos = f[startPos][target.charAt(ti) - 'a'] + 1;
                ++ti;
            }

        }
        return count;

    }

}
