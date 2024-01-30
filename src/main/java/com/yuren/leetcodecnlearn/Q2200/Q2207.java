package com.yuren.leetcodecnlearn.Q2200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-01-30 22:26
 */
public class Q2207 {
    public long maximumSubsequenceCount(String text, String pattern) {
        char front = pattern.charAt(0), back = pattern.charAt(1);
        long sum = 0;
        int fcnt = 0, bcnt = 0;
        // 从后向前遍历，统计pattern[0]和pattenr[1]的数量以及初始子序列数量。
        for (int i = text.length() - 1; i >= 0; i--) {
            char c = text.charAt(i);
            if (c == front) {
                sum += bcnt;
                fcnt++;
            }
            if (c == back) {
                bcnt++;
            }
        }
        // 返回初始子序列数量+新增的子序列数量
        return sum + Math.max(bcnt, fcnt);
    }
}
