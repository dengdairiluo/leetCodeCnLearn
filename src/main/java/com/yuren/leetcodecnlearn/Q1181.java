package com.yuren.leetcodecnlearn;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-11-28 23:28
 */
public class Q1181 {
    public List<String> beforeAndAfterPuzzles(String[] phrases) {
        // {key : word, val : [ 以 word 开头短语的索引构成的 list ] }
        HashMap<String, List<Integer>> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < phrases.length; i++) {
            // 获取第 i 个短语的首单词
            String phrase = phrases[i];
            int idx = phrase.indexOf(" ");
            String str = phrase;
            if (idx != -1) {
                str = phrase.substring(0, idx);
            }

            // 存储
            List<Integer> list = map.getOrDefault(str, new ArrayList<>());
            list.add(i);
            map.put(str, list);
        }
        // 拼接
        for (int i = 0; i < phrases.length; i++) {
            // 获取第 i 个短语的结尾单词 word
            String phrase = phrases[i];
            String[] strs = phrase.split(" ");
            String str = strs[strs.length - 1];
            // 获取 word 开头短语的索引
            List<Integer> list = map.getOrDefault(str, new ArrayList<>());
            for (int idx : list) {
                // 如果两个为同一个单词, 继续
                if (i == idx) {
                    continue;
                }
                // 拼接
                String item = phrases[idx];
                // 速度快
                String sb = phrase +
                        item.substring(str.length());
                set.add(sb);
            }
        }
        List<String> list = new ArrayList<>(set);
        // 排序
        Collections.sort(list);
        return list;
    }

}
