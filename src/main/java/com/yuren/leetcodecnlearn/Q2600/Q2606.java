package com.yuren.leetcodecnlearn.Q2600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-08-18 22:56
 */
public class Q2606 {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        int[] mapping = new int[26];
        for (int i = 0; i < 26; ++i)
            mapping[i] = i + 1;
        for (int i = 0; i < vals.length; ++i)
            mapping[chars.charAt(i) - 'a'] = vals[i];
        // 最大子段和（允许子数组为空）
        int ans = 0, f = 0;
        for (char c : s.toCharArray()) {
            f = Math.max(f, 0) + mapping[c - 'a'];
            ans = Math.max(ans, f);
        }
        return ans;
    }

}
