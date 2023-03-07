package com.yuren.leetcodecnlearn.Q900;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-08-08 23:51
 */
public class Q916 {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int n = words1.length;
        int m = words2.length;
        int[] cnt = new int[26];
        for (int i = 0; i < m; i++) {
            int[] temp = new int[26];
            String s = words2[i];
            for (int j = 0; j < s.length(); j++) {
                temp[s.charAt(j) - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                cnt[j] = Math.max(cnt[j], temp[j]);
            }
        }

        List<String> list = new ArrayList<>();
        out:
        for (int i = 0; i < n; i++) {
            int[] temp = new int[26];
            String s = words1[i];
            for (int j = 0; j < s.length(); j++) {
                temp[s.charAt(j) - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                if (cnt[j] > temp[j]) {
                    continue out;
                }
            }
            list.add(s);
        }
        return list;
    }
}
