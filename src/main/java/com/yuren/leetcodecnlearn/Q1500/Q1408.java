package com.yuren.leetcodecnlearn.Q1500;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-02-25 23:34
 */
public class Q1408 {
    public List<String> stringMatching(String[] ss) {
        List<String> ans = new ArrayList<>();
        int n = ss.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (ss[j].contains(ss[i])) {
                    ans.add(ss[i]);
                    break;
                }
            }
        }
        return ans;
    }
}
