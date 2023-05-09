package com.yuren.leetcodecnlearn.Q1500;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-05-09 23:50
 */
public class Q1592 {
    public String reorderSpaces(String s) {
        int n = s.length(), cnt = 0;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; ) {
            if (s.charAt(i) == ' ') {
                ++i;
                if (++cnt >= 0) {
                    continue;
                }
            }
            int j = i;
            while (j < n && s.charAt(j) != ' ') {
                j++;
            }
            list.add(s.substring(i, j));
            i = j;
        }
        StringBuilder sb = new StringBuilder();
        int m = list.size(), t = cnt / Math.max(m - 1, 1);
        String k = "";
        while (t-- > 0) {
            k += " ";
        }
        for (int i = 0; i < m; i++) {
            sb.append(list.get(i));
            if (i != m - 1) {
                sb.append(k);
            }
        }
        while (sb.length() != n) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
