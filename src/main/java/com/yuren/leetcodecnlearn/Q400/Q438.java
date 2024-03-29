package com.yuren.leetcodecnlearn.Q400;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-01-08 23:37
 */
public class Q438 {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length(), m = p.length();
        List<Integer> res = new ArrayList<>();
        if (n < m) return res;

        int[] pCnt = new int[26];
        int[] sCnt = new int[26];

        for (int i = 0; i < m; i++) {
            pCnt[p.charAt(i) - 'a']++;
        }

        int left = 0;
        for (int right = 0; right < n; right++) {
            int curRight = s.charAt(right) - 'a';
            sCnt[curRight]++;
            while (sCnt[curRight] > pCnt[curRight]) {
                int curLeft = s.charAt(left) - 'a';
                sCnt[curLeft]--;
                left++;
            }
            if (right - left + 1 == m) {
                res.add(left);
            }
        }
        return res;
    }
}
