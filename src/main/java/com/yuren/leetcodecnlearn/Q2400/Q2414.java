package com.yuren.leetcodecnlearn.Q2400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-05-15 下午10:44
 */
public class Q2414 {
    public int longestContinuousSubstring(String s) {
        int maxLength = 1;
        int currLength = 1;
        int length = s.length();
        for (int i = 1; i < length; i++) {
            if (s.charAt(i) - s.charAt(i - 1) == 1) {
                currLength++;
                maxLength = Math.max(maxLength, currLength);
            } else {
                currLength = 1;
            }
        }
        return maxLength;
    }
}
