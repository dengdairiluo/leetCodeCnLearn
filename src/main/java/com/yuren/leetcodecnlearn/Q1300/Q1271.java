package com.yuren.leetcodecnlearn.Q1300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-10 00:00
 */
public class Q1271 {
    public String toHexspeak(String num) {

        long value = Long.parseLong(num), modValue;
        StringBuilder result = new StringBuilder();

        while (value != 0) {
            // 相当于 % 16
            modValue = value & 15;
            // 如果余数是0
            if (modValue == 0) {
                result.append('O');
            // 如果余数是1
            } else if (modValue == 1) {
                result.append('I');
            // 如果余数大于10，从“A” 开始
            } else if (modValue >= 10) {
                result.append((char) ('A' + modValue - 10));
            } else {
                return "ERROR";
            }

            value >>= 4;
        }
        return result.reverse().toString();

    }
}
