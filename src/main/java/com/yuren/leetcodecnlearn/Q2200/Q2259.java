package com.yuren.leetcodecnlearn.Q2200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-02-25 23:45
 */
public class Q2259 {
    public String removeDigit(String number, char digit) {
        int removeIndex = -1, lastIndex = -1;
        int length = number.length();
        for (int i = 0; i < length && removeIndex < 0; i++) {
            if (number.charAt(i) == digit) {
                if (i < length - 1 && number.charAt(i + 1) > digit) {
                    removeIndex = i;
                }
                lastIndex = i;
            }
        }
        if (removeIndex < 0) {
            removeIndex = lastIndex;
        }
        String maximum = number.substring(0, removeIndex) + number.substring(removeIndex + 1);
        return maximum;
    }
}
