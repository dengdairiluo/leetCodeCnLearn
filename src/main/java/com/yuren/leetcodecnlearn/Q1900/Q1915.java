package com.yuren.leetcodecnlearn.Q1900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-09-09 23:46
 */
public class Q1915 {
    public long wonderfulSubstrings(String word) {
        int[] cnt = new int[1024];
        // 初始前缀和为 0，需将其计入出现次数
        cnt[0] = 1;
        long ans = 0L;
        for (int i = 0, sum = 0; i < word.length(); ++i) {
            // 计算当前前缀和
            sum ^= 1 << (word.charAt(i) - 'a');
            ans += cnt[sum]; // 所有字母均出现偶数次
            // 枚举其中一个字母出现奇数次
            for (int j = 1; j < 1024; j <<= 1) {
                // 反转该字母的出现次数的奇偶性
                ans += cnt[sum ^ j];
            }
            // 更新前缀和出现次数
            ++cnt[sum];
        }
        return ans;
    }
}
