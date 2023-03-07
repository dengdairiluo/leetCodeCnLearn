package com.yuren.leetcodecnlearn.Q800;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-07-25 22:55
 */
public class Q884 {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> freq = new HashMap<>();
        insert(s1, freq);
        insert(s2, freq);

        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 1) {
                ans.add(entry.getKey());
            }
        }
        return ans.toArray(new String[0]);
    }

    public void insert(String s, Map<String, Integer> freq) {
        String[] arr = s.split(" ");
        for (String word : arr) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
    }
}
