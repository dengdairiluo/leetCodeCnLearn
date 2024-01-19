package com.yuren.leetcodecnlearn.Q2100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-01-19 23:32
 */
public class Q2185 {
    public int prefixCount(String[] words, String pref) {
        int ans = 0;
        for (String s : words) if (s.startsWith(pref)) ans++;
        return ans;
    }
}
