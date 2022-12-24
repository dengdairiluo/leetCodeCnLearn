package com.yuren.leetcodecnlearn.Q1200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-11-27 21:21
 */
public class Q1178 {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        // 统计所有word的二进制状态压缩
        Map<Integer, Integer> map = new HashMap<>();
        for (String word : words) {
            int mask = 0;
            for (char c : word.toCharArray()) {
                mask |= (1 << (c - 'a'));
            }
            if (Integer.bitCount(mask) <= 7) {
                map.put(mask, map.getOrDefault(mask, 0) + 1);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (String puzzle : puzzles) {
            char[] cp = puzzle.toCharArray();
            int total = 0;

            // 枚举子集方法二
            int mask = 0;
            for (int i = 1; i < 7; i++) {
                mask |= (1 << (cp[i] - 'a'));
            }
            int subset = mask;
            do {
                int s = subset | (1 << (cp[0] - 'a'));
                if (map.containsKey(s)) {
                    total += map.get(s);
                }

                // 全0时再次-1等于mask
                subset = (subset - 1) & mask;
            } while (subset != mask);

            ans.add(total);
        }

        return ans;
    }
}
