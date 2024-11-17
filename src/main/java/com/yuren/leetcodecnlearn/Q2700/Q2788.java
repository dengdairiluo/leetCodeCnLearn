package com.yuren.leetcodecnlearn.Q2700;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-11-17 23:21
 */
public class Q2788 {

    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> list = new ArrayList<>();
        for (String w : words) {
            String[] value = w.split(String.valueOf("\\" + separator));
            for (String s : value) {
                if (!s.isEmpty()) {
                    list.add(s);
                }
            }
        }
        return list;
    }
}
