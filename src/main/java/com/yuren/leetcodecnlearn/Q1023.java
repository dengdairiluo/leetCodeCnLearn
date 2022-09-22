package com.yuren.leetcodecnlearn;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-09-22 23:25
 */
public class Q1023 {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();
        char[] cs = pattern.toCharArray();
        int len = cs.length;
        for (String query : queries) {
            int p = 0;
            boolean cur = true;
            for (char c : query.toCharArray()) {
                if (p < len && c == cs[p]) {
                    p++;
                } else if (c >= 'A' && c <= 'Z') {
                    //大写字母不能跳
                    cur = false;
                    break;
                }
            }
            //所有的pattern都要检查到
            ans.add(cur ? p == len : cur);
        }
        return ans;
    }
}
