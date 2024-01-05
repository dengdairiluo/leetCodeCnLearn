package com.yuren.leetcodecnlearn.Q2100;

import java.util.HashMap;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-01-05 23:54
 */
public class Q2157 {
    // 并查集模板（哈希表写法）
    HashMap<Integer, Integer> fa = new HashMap<>(), size = new HashMap<>();
    int groups, maxSize;

    int find(int x) {
        if (fa.get(x) != x) fa.put(x, find(fa.get(x)));
        return fa.get(x);
    }

    void merge(int x, int y) {
        if (!fa.containsKey(y)) return;
        x = find(x);
        y = find(y);
        if (x == y) return;
        fa.put(x, y);
        size.put(y, size.get(y) + size.get(x));
        maxSize = Math.max(maxSize, size.get(y)); // 维护答案
        --groups;
    }

    public int[] groupStrings(String[] words) {
        groups = words.length;
        for (String word : words) {
            int x = 0;
            for (int i = 0; i < word.length(); i++)
                x |= 1 << (word.charAt(i) - 'a'); // 计算 word 的二进制表示
            fa.put(x, x); // 添加至并查集
            size.put(x, size.getOrDefault(x, 0) + 1);
            maxSize = Math.max(maxSize, size.get(x)); // 维护答案
            if (size.get(x) > 1) --groups;
        }

        fa.forEach((x, fx) -> {
            for (int i = 0; i < 26; i++) {
                merge(x, x ^ (1 << i)); // 添加或删除字符 i
                if (((x >> i) & 1) == 1)
                    for (int j = 0; j < 26; ++j)
                        if (((x >> j) & 1) == 0)
                            merge(x, x ^ (1 << i) | (1 << j)); // 替换字符 i 为 j
            }
        });
        return new int[]{groups, maxSize};
    }
}
