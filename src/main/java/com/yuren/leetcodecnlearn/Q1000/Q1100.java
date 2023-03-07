package com.yuren.leetcodecnlearn.Q1000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-10-25 23:50
 */
public class Q1100 {
    public int numKLenSubstrNoRepeats(String s, int k) {
        int len = s.length();
        if (k > 26 || k > len) {
            return 0;
        }

        int[] freq = new int[123];
        int cnt = 0;
        int ans = 0;
        char[] chars = s.toCharArray();

        //初始化窗口
        for (int i = 0; i < k; i++) {
            if (freq[chars[i]]++ == 0) {
                cnt++;
            }
        }
        if (cnt == k) {
            ans++;
        }

        //固定窗口大小，向右滑动
        for (int l = 0, r = k; r < len; ) {
            if (--freq[chars[l++]] == 0)
                cnt--;
            if (freq[chars[r++]]++ == 0)
                cnt++;
            if (cnt == k)
                ans++;
        }

        return ans;
    }
}
