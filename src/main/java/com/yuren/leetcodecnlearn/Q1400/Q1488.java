package com.yuren.leetcodecnlearn.Q1400;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-03-27 22:57
 */
public class Q1488 {
    /**
     * 贪心 + 二分(用TreeSet省略自己实现)
     * 将晴天的日期全部记录到 set<int> zero 中
     * 使用 map<int, int> water 来记录每个湖泊上一次下雨的日期
     */
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        // 用map记录每个湖泊上一次下雨的日期
        Map<Integer, Integer> lastDayMap = new HashMap<>();
        int[] res = new int[n];
        TreeSet<Integer> zero = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                zero.add(i);
                //随便抽一个，后面如果有需要直接覆盖
                res[i] = 1;
            } else {
                res[i] = -1;
                if (lastDayMap.containsKey(rains[i])) {
                    Integer draw = zero.ceiling(lastDayMap.get(rains[i]));
                    if (draw == null) {
                        return new int[0];
                    }
                    res[draw] = rains[i];
                    zero.remove(draw);
                }
                lastDayMap.put(rains[i], i);
            }
        }
        return res;
    }
}
