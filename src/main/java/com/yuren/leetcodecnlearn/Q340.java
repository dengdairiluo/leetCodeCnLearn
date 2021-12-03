package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-12-03 23:39
 */
public class Q340 {
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) return 0;
        char[] str = s.toCharArray();
        // [l ... r) 窗口左右边界，左闭右开。kinds：窗口内的字符种类数
        int n = str.length, l = 0, r = 0, kinds = 0, ans = 0;
        int[] charCounts = new int[256]; // 字符频数数组
        while (l < n) {
            // 窗口右边界不断向右滑动，直至窗口内不达标
            while (r < n && (kinds < k || (kinds == k && charCounts[str[r]] != 0))) {
                kinds += charCounts[str[r]] == 0 ? 1 : 0;
                charCounts[str[r++]]++;
            }
            ans = Math.max(ans, r - l); // 结算此时以[l]开头时的最大长度
            // 窗口左边界向右缩进一个字符：[l]字符出窗口
            kinds -= charCounts[str[l]] == 1 ? 1 : 0;
            charCounts[str[l++]]--;
        }
        return ans;
    }
}
