package com.yuren.leetcodecnlearn.Q1400;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-03-13 23:45
 */
public class Q1451 {
    public String arrangeWords(String text) {
        char[] chars = text.toCharArray();
        int n = chars.length;
        chars[0] = (char) (chars[0] + 32);

        Map<Integer, List<Integer>> map = new TreeMap<>();
        int start = 0;
        for (int i = 1; i < n; i++) {
            if (chars[i] == ' ') {
                map.computeIfAbsent(i - start, k -> new ArrayList<>()).add(start);
                start = i + 1;
            }
        }
        map.computeIfAbsent(n - start, k -> new ArrayList<>()).add(start);

        StringBuilder result = new StringBuilder();
        for (int len : map.keySet()) {
            for (int index : map.get(len)) {
                while (index < n && chars[index] != ' ') {
                    result.append(chars[index]);
                    index++;
                }
                result.append(" ");
            }
        }

        result.setCharAt(0, (char) (result.charAt(0) - 32));

        return result.substring(0, result.length() - 1);
    }
}
