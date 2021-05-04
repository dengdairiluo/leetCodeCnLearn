package com.yuren.leetcodecnlearn;

import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-02-28 21:06
 */
public class Q5689 {


    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {

        if (null == items || 0 == items.size()) {
            return 0;
        }

        int ans = 0;

        int col = -1;
        if ("type".equals(ruleKey)) {
            col = 0;
        } else if ("color".equals(ruleKey)) {
            col = 1;
        } else {
            col = 2;
        }
        for (List<String> item : items) {
            if (ruleValue.equals(item.get(col))) {
                ans++;
            }
        }

        return ans;
    }
}
