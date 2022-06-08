package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-06-08 22:38
 */
public class Q777 {
    public boolean canTransform(String start, String end) {
        int length = start.length();
        int index1 = 0, index2 = 0;
        while (index1 < length && index2 < length) {
            while (index1 < length && start.charAt(index1) == 'X') {
                index1++;
            }
            while (index2 < length && end.charAt(index2) == 'X') {
                index2++;
            }
            if (index1 < length && index2 < length) {
                char c1 = start.charAt(index1), c2 = end.charAt(index2);
                if (c1 != c2) {
                    return false;
                }
                if (c1 == 'L' && index1 < index2 || c1 == 'R' && index1 > index2) {
                    return false;
                }
                index1++;
                index2++;
            }
        }
        while (index1 < length) {
            if (start.charAt(index1) != 'X') {
                return false;
            }
            index1++;
        }
        while (index2 < length) {
            if (end.charAt(index2) != 'X') {
                return false;
            }
            index2++;
        }
        return true;
    }
}
