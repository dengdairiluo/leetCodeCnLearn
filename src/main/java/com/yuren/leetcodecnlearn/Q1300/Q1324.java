package com.yuren.leetcodecnlearn.Q1300;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-25 23:30
 */
public class Q1324 {
    public List<String> printVertically(String s) {
        String[] split = s.split("\\ ");
        List<String> list = new ArrayList<>();
        int maxLength = 0;
        for (String s1 : split) {
            int tempLength = s1.length();
            if (tempLength > maxLength) {
                maxLength = tempLength;
            }
        }
        for (int i = 0; i < maxLength; i++) {
            StringBuilder sb = new StringBuilder();
            for (String s1 : split) {
                int tempLength = s1.length();
                if (tempLength > i) {
                    char c = s1.charAt(i);
                    sb.append(c);
                } else if (tempLength <= i) {
                    sb.append(" ");
                }
            }
            int endIndex = sb.length() - 1;
            for (; endIndex >= 0; endIndex--) {
                char c = sb.charAt(endIndex);
                if (c != ' ') {
                    break;
                }
            }
            list.add(sb.substring(0, endIndex + 1));
        }
        return list;
    }
}
