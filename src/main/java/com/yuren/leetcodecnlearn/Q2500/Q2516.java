package com.yuren.leetcodecnlearn.Q2500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-07-04 下午11:53
 */
public class Q2516 {
    public int takeCharacters(String s, int k) {
        int[] remains = new int[3];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            remains[c - 'a']++;
        }
        for (int i = 0; i < 3; i++) {
            remains[i] -= k;
            if (remains[i] < 0) {
                return -1;
            }
        }
        int minMinutes = n;
        int start = 0, end = 0;
        while (end < n) {
            char curr = s.charAt(end);
            remains[curr - 'a']--;
            while (remains[curr - 'a'] < 0) {
                char prev = s.charAt(start);
                remains[prev - 'a']++;
                start++;
            }
            minMinutes = Math.min(minMinutes, n - (end - start + 1));
            end++;
        }
        return minMinutes;
    }
}
