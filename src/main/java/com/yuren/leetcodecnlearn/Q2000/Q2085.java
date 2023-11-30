package com.yuren.leetcodecnlearn.Q2000;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-11-30 22:30
 */
public class Q2085 {
    public int countWords(String[] words1, String[] words2) {
        int n = words1.length, l = words2.length;
        Map<String, Integer> map = new HashMap<>(Math.min(n, l));
        for (String words : n < l ? words1 : words2) {
            map.put(words, map.getOrDefault(words, 0) + 1);
        }
        int ret = 0;
        for (String words : l > n ? words2 : words1) {
            if (map.containsKey(words)) {
                int cut = map.get(words);
                if (cut == 1) {
                    ++ret;
                    map.put(words, -1);
                } else if (cut == -1) {
                    --ret;
                    map.put(words, 0);
                }
            }
        }
        return ret;
    }
}
