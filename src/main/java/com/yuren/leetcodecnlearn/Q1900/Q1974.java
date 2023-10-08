package com.yuren.leetcodecnlearn.Q1900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-10-08 23:54
 */
public class Q1974 {
    public int minTimeToType(String word) {
        char[] chars = word.toCharArray();
        int count = 0;
        char tempChar = 'a';
        for (char aChar : chars) {
            if (aChar == tempChar) {
                count += 1;
            } else if (aChar > tempChar) {
                int num1 = aChar - tempChar;
                int num2 = tempChar + 26 - aChar;
                count += Math.min(num1, num2) + 1;
            } else {
                int num3 = tempChar - aChar;
                int num4 = aChar - tempChar + 26;
                count += Math.min(num3, num4) + 1;
            }
            tempChar = aChar;
        }
        return count;
    }
}
