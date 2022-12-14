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
 * @date 2022-05-20 23:50
 */
public class Q734 {
    public boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) return false;
        Map<String, List<String>> map = new HashMap<>();
        if (!pairs.isEmpty()) {
            for (List<String> pair : pairs) {
                List<String> val1 = map.get(pair.get(0));
                if (val1 == null) val1 = new ArrayList<>();
                val1.add(pair.get(1));
                map.put(pair.get(0), val1);
                List<String> val2 = map.get(pair.get(1));
                if (val2 == null) val2 = new ArrayList<>();
                val2.add(pair.get(0));
                map.put(pair.get(1), val2);
            }
        }

        //2.逐一比较两个单词
        for (int i = 0; i < words1.length; i++) {
            //相等的单词也是对应词
            if (words1[i].equals(words2[i]))
                continue;
            if (!map.isEmpty()) {
                //获取对应的词
                List<String> list = map.get(words1[i]);
                if (list == null || !list.contains(words2[i]))
                    return false;
            }
        }
        return true;
    }

}
