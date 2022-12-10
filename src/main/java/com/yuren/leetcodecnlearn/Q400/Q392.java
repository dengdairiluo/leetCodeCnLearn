package com.yuren.leetcodecnlearn.Q400;

public class Q392 {
    public boolean isSubsequence(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        int slow = 0;
        int fast = 0;
        for (; slow < sLength && fast < tLength; fast++) {
            if (s.charAt(slow) == t.charAt(fast)) {
                slow++;
                if (slow == sLength) {
                    //说明已经在t中找到了子序列 等于s
                    break;
                }
            }
        }
        return slow == sLength;
    }
}
