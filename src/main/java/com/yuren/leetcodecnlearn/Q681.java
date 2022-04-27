package com.yuren.leetcodecnlearn;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-04-27 23:45
 */
public class Q681 {
    public String nextClosestTime(String time) {
        char[] chars = new char[4];
        chars[0] = time.charAt(0);
        chars[1] = time.charAt(1);
        chars[2] = time.charAt(3);
        chars[3] = time.charAt(4);
        Arrays.sort(chars);
        char[] chars1 = time.toCharArray();
        char temp = chars1[4];
        chars1[4] = this.findNextCharacter(chars1[4], '9', chars);
        if (chars1[4] > temp) {
            return new String(chars1);
        }
        temp = chars1[3];
        chars1[3] = this.findNextCharacter(chars1[3], '5', chars);
        if (chars1[3] > temp) {
            return new String(chars1);
        }
        temp = chars1[1];
        chars1[1] = this.findNextCharacter(chars1[1], chars1[0] == '2' ? '3' : '9', chars);
        if (chars1[1] > temp) {
            return new String(chars1);
        }
        chars1[0] = this.findNextCharacter(chars1[0], '2', chars);
        return new String(chars1);
    }

    private char findNextCharacter(char current, char upperLimit, char[] digits) {
        if (current == upperLimit) return digits[0];
        int idx = this.binarySearch(digits, 0, digits.length - 1, current);
        while (idx < digits.length && digits[idx] == current)
            ++idx;
        return (idx == digits.length || digits[idx] > upperLimit) ? digits[0] : digits[idx];
    }

    private int binarySearch(char[] chars, int left, int right, char target) {
        if (left > right) return -1;
        int pivot = left + ((right - left) >>> 1);
        if (chars[pivot] == target) return pivot;
        else if (chars[pivot] > target) return this.binarySearch(chars, left, pivot - 1, target);
        else return this.binarySearch(chars, pivot + 1, right, target);
    }
}
