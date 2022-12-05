package com.yuren.leetcodecnlearn.Q100;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-09-04 22:40
 */
public class Q76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> hs = new HashMap<>();
        Map<Character, Integer> ht = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            ht.put(t.charAt(i), ht.getOrDefault(t.charAt(i), 0) + 1);
        }
        String ans = "";
        //有多少个元素符合
        int len = 0x3f3f3f3f, cnt = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            hs.put(s.charAt(i), hs.getOrDefault(s.charAt(i), 0) + 1);
            if (ht.containsKey(s.charAt(i)) && hs.get(s.charAt(i)) <= ht.get(s.charAt(i))) cnt++;
            while (j < i && (!ht.containsKey(s.charAt(j)) || hs.get(s.charAt(j)) > ht.get(s.charAt(j)))) {
                int count = hs.get(s.charAt(j)) - 1;
                hs.put(s.charAt(j), count);
                j++;
            }
            if (cnt == t.length() && i - j + 1 < len) {
                len = i - j + 1;
                ans = s.substring(j, i + 1);
            }
        }
        return ans;
    }

}
