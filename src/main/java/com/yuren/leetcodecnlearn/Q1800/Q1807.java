package com.yuren.leetcodecnlearn.Q1800;

import java.util.HashMap;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-08-01 23:45
 */
public class Q1807 {
    public String evaluate(String s, List<List<String>> knowledge) {

        HashMap<String, String> keyMap = new HashMap<>();

        for (List<String> items : knowledge) {
            keyMap.put(items.get(0), items.get(1));
        }

        int left = 0, right = 0;
        int length = s.length();
        StringBuilder res = new StringBuilder();
        boolean inFlag = false;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < length; ++i) {
            if (charArray[i] == '(') {
                left = i;
                inFlag = true;
                continue;
            }
            if (charArray[i] == ')') {
                right = i;
                inFlag = false;
                String replaced = keyMap.getOrDefault(s.substring(left + 1, right), "?");
                res.append(replaced);
                continue;
            }
            if (!inFlag) {
                res.append(charArray[i]);
            }
        }
        return res.toString();
    }
}
