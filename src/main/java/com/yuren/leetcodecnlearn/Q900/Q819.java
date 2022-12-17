package com.yuren.leetcodecnlearn.Q900;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-06-26 23:49
 */
public class Q819 {
    public String mostCommonWord(String s, String[] banned) {
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        char[] cs = s.toCharArray();
        int n = cs.length;
        String ans = null;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ) {
            if (!Character.isLetter(cs[i])) {
                ++i;
                continue;
            }
            int j = i;
            while (j < n && Character.isLetter(cs[j])) {
                j++;
            }
            String sub = s.substring(i, j).toLowerCase();
            i = j + 1;
            if (set.contains(sub)) {
                continue;
            }
            map.put(sub, map.getOrDefault(sub, 0) + 1);
            if (ans == null || map.get(sub) > map.get(ans)) {
                ans = sub;
            }
        }
        return ans;
    }
}
