package com.yuren.leetcodecnlearn.Q2500;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-07-28 下午10:34
 */
public class Q2564 {
    public int[][] substringXorQueries(String s, int[][] queries) {
        // 预处理
        Map<Integer, int[]> map = new HashMap<>();
        int len = s.length();
        // 31位会超过1e9 (queries元素的范围)
        for (int i = 30; i > 0; --i) {
            for (int j = len - i; j >= 0; --j) {
                map.put(Integer.valueOf(s.substring(j, i + j), 2), new int[]{j, i + j - 1});
            }
        }
        int[][] res = new int[queries.length][2];
        // 遍历queries, a ^ b = x  -->  x ^ a = b;
        for (int i = 0; i < queries.length; ++i) {
            res[i] = map.getOrDefault(queries[i][0] ^ queries[i][1], new int[]{-1, -1});
        }
        return res;
    }
}
