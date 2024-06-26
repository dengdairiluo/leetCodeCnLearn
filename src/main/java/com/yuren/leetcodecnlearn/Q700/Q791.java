package com.yuren.leetcodecnlearn.Q700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-06-15 23:31
 */
public class Q791 {
    public String customSortString(String s, String t) {
        // count[char] = the number of occurrences of 'char' in T.
        // This is offset so that count[0] = occurrences of 'a', etc.
        // 'count' represents the current state of characters
        // (with multiplicity) we need to write to our answer.
        int[] count = new int[26];
        for (char c : t.toCharArray()) {
            count[c - 'a']++;
        }

        // ans will be our final answer.  We use StringBuilder to join
        // the answer so that we more efficiently calculate a
        // concatenation of strings.
        StringBuilder ans = new StringBuilder();

        // Write all characters that occur in S, in the order of S.
        for (char c : s.toCharArray()) {
            for (int i = 0; i < count[c - 'a']; ++i) {
                ans.append(c);
            }
            // Setting count[char] to zero to denote that we do
            // not need to write 'char' into our answer anymore.
            count[c - 'a'] = 0;
        }

        // Write all remaining characters that don't occur in S.
        // That information is specified by 'count'.
        for (char c = 'a'; c <= 'z'; ++c) {
            for (int i = 0; i < count[c - 'a']; ++i) {
                ans.append(c);
            }
        }

        return ans.toString();
    }
}
