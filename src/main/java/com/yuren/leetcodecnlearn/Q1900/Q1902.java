package com.yuren.leetcodecnlearn.Q1900;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-09-04 23:20
 */
public class Q1902 {
    public int maxDepthBST(int[] order) {
        // 元素->高度
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        // 初始化边界
        tm.put(0, 0);
        tm.put(Integer.MAX_VALUE, 0);
        // 首元素
        tm.put(order[0], 1);
        int ans = 1;
        for (int i = 1; i < order.length; i++) {
            int val = order[i];
            Map.Entry<Integer, Integer> lower = tm.lowerEntry(val);
            Map.Entry<Integer, Integer> higher = tm.higherEntry(val);
            int depth = Math.max(lower.getValue(), higher.getValue()) + 1;
            tm.put(val, depth);
            ans = Math.max(ans, depth);
        }
        return ans;
    }
}
