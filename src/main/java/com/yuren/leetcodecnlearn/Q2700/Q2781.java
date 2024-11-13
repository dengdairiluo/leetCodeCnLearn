package com.yuren.leetcodecnlearn.Q2700;

import java.util.HashSet;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-11-13 23:46
 */
public class Q2781 {
    public int longestValidSubstring(String word, List<String> forbidden) {
        var fb = new HashSet<>(forbidden);
        int ans = 0, left = 0, n = word.length();
        for (int right = 0; right < n; right++) {
            for (int i = right; i >= left && i > right - 10; i--) {
                if (fb.contains(word.substring(i, right + 1))) {
                    // 当子串右端点 >= right 时，合法子串一定不能包含 word[i]
                    left = i + 1;
                    break;
                }
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
