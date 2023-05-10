package com.yuren.leetcodecnlearn.Q1500;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-05-10 23:52
 */
public class Q1593 {
    Set<String> set = new HashSet<>();
    String s;
    int ans = 0;

    public int maxUniqueSplit(String s) {
        this.s = s;
        bt(0);
        return ans;
    }

    private void bt(int index) {
        if (index == s.length()) {
            ans = Math.max(ans, set.size());
            return;
        }
        for (int len = 1; index + len <= s.length() && index + len + ans <= s.length() + set.size(); len++) {
            String sub = s.substring(index, index + len);
            if (set.add(sub)) {
                bt(index + len);
                set.remove(sub);
            }
        }
    }
}
