package com.yuren.leetcodecnlearn.Q2600;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-09-19 23:19
 */
public class Q2671 {

    private final Map<Integer, Integer> cnt = new HashMap<>(); // number 的出现次数
    private final Map<Integer, Integer> freq = new HashMap<>(); // number 的出现次数的出现次数

    public Q2671() {
    }

    private void update(int number, int delta) {
        int c = cnt.merge(number, delta, Integer::sum);
        // 去掉一个旧的 cnt[number]
        freq.merge(c - delta, -1, Integer::sum);
        // 添加一个新的 cnt[number]
        freq.merge(c, 1, Integer::sum);
    }

    public void add(int number) {
        update(number, 1);
    }

    public void deleteOne(int number) {
        if (cnt.getOrDefault(number, 0) > 0) {
            update(number, -1);
        }
    }

    public boolean hasFrequency(int frequency) {
        // 至少有一个 number 的出现次数恰好为 frequency
        return freq.getOrDefault(frequency, 0) > 0;
    }
}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */

