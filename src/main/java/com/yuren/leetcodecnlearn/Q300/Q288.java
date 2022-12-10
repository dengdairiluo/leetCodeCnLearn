package com.yuren.leetcodecnlearn.Q300;

import java.util.HashMap;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-11-13 23:36
 */
public class Q288 {

    private final HashMap<String, String> map = new HashMap<>();

    public Q288(String[] dictionary) {
        for (String s : dictionary) {
            String unique = unique(s); // 单词缩写
            String v = map.get(unique); // 单词缩写对应历史放入的单词
            if (v == null) {
                map.put(unique, s); // 如果历史未放入，新增
            } else {
                // 如果新放入的不是重复的，重置为 "" ，表示至少放入 2 个，永远不是唯一缩写
                if (!v.equals(s)) map.put(unique, "");
            }
        }
    }

    public boolean isUnique(String word) {
        String v = map.get(unique(word));
        return v == null || v.equals(word);
    }

    // 单词缩写方法
    private String unique(String word) {
        int length = word.length();
        if (length < 3) return word;
        return word.charAt(0) + String.valueOf(length - 2) + word.charAt(length - 1);
    }
}
