package com.yuren.leetcodecnlearn.Q2100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-01-24 23:30
 */
public class Q2194 {
    public List<String> cellsInRange(String s) {
        int row1 = s.charAt(1);
        int row2 = s.charAt(4);
        int col1 = s.charAt(0);
        int col2 = s.charAt(3);
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = col1; i <= col2; i++) {
            for (int j = row1; j <= row2; j++) {
                sb.append((char) i).append((char) j);
                ans.add(sb.toString());
                sb.setLength(0);
            }
        }
        return ans;
    }
}
