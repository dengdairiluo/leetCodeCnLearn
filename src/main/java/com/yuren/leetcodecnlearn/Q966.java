package com.yuren.leetcodecnlearn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-08-29 23:58
 */
public class Q966 {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> words = new HashSet<>();
        Map<String, String> map = new HashMap<>();
        Map<String, String> rep = new HashMap<>();
        for (String word : wordlist) {
            words.add(word);
            map.putIfAbsent(word.toLowerCase(), word);
            String newWord = word.toLowerCase().replace('a', '0').replace('e', '0').replace('i', '0').replace('o', '0')
                    .replace('u', '0');
            rep.putIfAbsent(newWord, word);
        }
        String[] ans = new String[queries.length];
        int p = 0;
        for (String query : queries) {
            if (words.contains(query)) {
                ans[p] = query;
            } else if (map.containsKey(query.toLowerCase())) {
                ans[p] = map.get(query.toLowerCase());
            } else {
                String newWord = query.toLowerCase().replace('a', '0').replace('e', '0').replace('i', '0')
                        .replace('o', '0').replace('u', '0');
                if (rep.containsKey(newWord)) {
                    ans[p] = rep.get(newWord);
                } else {
                    ans[p] = "";
                }
            }
            p++;
        }
        return ans;
    }
}
