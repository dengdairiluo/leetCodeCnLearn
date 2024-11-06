package com.yuren.leetcodecnlearn.Q2700;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-11-06 23:38
 */
public class Q2767 {

    // 15位长度二进制，对应5的幂最大值5^6=15625
    private static final HashSet<String> FIVE_BINARY_STR_SET = new HashSet<>(Arrays
            .asList("11110100001001", "110000110101", "1001110001", "1111101", "11001", "101", "1"));

    public int minimumBeautifulSubstrings(String s) {
        int rs = minimumBeautifulSubstrings(s, new HashMap<>());
        return rs == Integer.MAX_VALUE ? -1 : rs;
    }

    public int minimumBeautifulSubstrings(String s, HashMap<String, Integer> subStrMinCntMap) {
        if ("".equals(s)) {
            return 0;
        }
        int minCnt = Integer.MAX_VALUE;
        // 枚举
        for (String key : FIVE_BINARY_STR_SET) {
            if (s.indexOf(key) == 0) {
                String newStr = s.substring(key.length());
                int nextMinCnt = 0;
                // 优先从缓存查找
                if (subStrMinCntMap.containsKey(newStr)) {
                    nextMinCnt = subStrMinCntMap.get(newStr);
                } else {
                    // 递归
                    nextMinCnt = minimumBeautifulSubstrings(newStr, subStrMinCntMap);
                    // 缓存
                    subStrMinCntMap.put(newStr, nextMinCnt);
                }
                if (nextMinCnt != Integer.MAX_VALUE) {
                    minCnt = Math.min(minCnt, 1 + nextMinCnt);
                }
            }
        }

        // 缓存
        subStrMinCntMap.put(s, minCnt);
        return minCnt;
    }
}
