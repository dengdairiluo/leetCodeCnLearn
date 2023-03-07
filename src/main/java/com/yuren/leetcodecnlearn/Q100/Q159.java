package com.yuren.leetcodecnlearn.Q100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-10-01 23:12
 */
public class Q159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length(), l = 0, r = 0;
        int ans = 0;
        int[] cnt = new int[58];
        int valid = 0;
        while (r < n) {
            char c = s.charAt(r);
            if (cnt[c - 'A'] == 0) {
                valid++;
            }
            cnt[c - 'A']++;
            while (valid > 2) {
                char d = s.charAt(l++);
                int num = cnt[d - 'A'];
                if (num == 1) valid--;
                cnt[d - 'A']--;
            }
            r++;
            ans = Math.max(ans, r - l);
        }
        return ans;

    }
}
