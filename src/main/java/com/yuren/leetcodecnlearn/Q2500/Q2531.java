package com.yuren.leetcodecnlearn.Q2500;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-07-11 下午11:52
 */
public class Q2531 {
    public boolean isItPossible(String word1, String word2) {
        Map<Character, Integer> c1 = new HashMap<>(), c2 = new HashMap<>();
        for (char c : word1.toCharArray()) c1.merge(c, 1, Integer::sum);
        for (char c : word2.toCharArray()) c2.merge(c, 1, Integer::sum);
        for (Map.Entry<Character, Integer> e : c1.entrySet())
            for (Map.Entry<Character, Integer> f : c2.entrySet()) {
                char x = e.getKey(), y = f.getKey();
                if (x == y) {
                    if (c1.size() == c2.size()) return true;
                } else if (c1.size() - (e.getValue() == 1 ? 1 : 0) + (c1.containsKey(y) ? 0 : 1) ==
                        c2.size() - (f.getValue() == 1 ? 1 : 0) + (c2.containsKey(x) ? 0 : 1)) // 基于长度计算变化量
                    return true;
            }
        return false;
    }
}
