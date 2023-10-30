package com.yuren.leetcodecnlearn.Q2000;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-10-30 23:06
 */
public class Q2023 {
    public int numOfPairs(String[] nums, String target) {
        int cnt = 0;
        Map<String, Integer> cntMap = new HashMap<>();
        for (String num : nums) {
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);

        }
        for (String num : nums) {
            if (target.startsWith(num)) {
                cnt = cnt + cntMap.getOrDefault(target.substring(num.length()), 0) + (num.equals(target.substring(num.length())) ? -1 : 0);
            }
        }
        return cnt;
    }
}
