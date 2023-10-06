package com.yuren.leetcodecnlearn.Q1900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-10-06 23:49
 */
public class Q1961 {
    public boolean isPrefixString(String s, String[] words) {
        int sLen = s.length();
        int sumLen = 0;
        int sumLen2;
        for (String word : words) {
            int tmpLen = word.length();
            sumLen2 = sumLen;
            sumLen += tmpLen;

            if (sumLen > sLen) {
                return false;
            }
            for (int i = sumLen2; i < sumLen; i++) {
                if (s.charAt(i) != word.charAt(i - sumLen2)) {
                    return false;
                }
            }
            if (sumLen == sLen) {
                return true;
            }
        }
        return false;
    }
}
