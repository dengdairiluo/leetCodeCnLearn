package com.yuren.leetcodecnlearn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-11-04 23:11
 */
public class Q267 {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();

        if (s.length() == 0) {
            return res;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        // 统计奇数字符的个数
        int count = 0;
        int size = 0;
        Character ch = null;
        for (char key : map.keySet()) {
            if (map.get(key) % 2 == 1) {
                ch = key;
                count += 1;
                // 把多出来的一个奇数字符删除
                map.put(key, map.get(key) - 1);
            }
            size += map.get(key) / 2;
        }
        if (count > 1) return res;

        // 获得需要进行全排列的字符数组，从map中获取
        int k, idx = 0;
        char[] chars = new char[size];
        for (char key : map.keySet()) {
            // 比如遇到有重复的['a','a','a','a']，那么只向char中添加两个'a',即 ['a','a']
            for (k = 0; k < map.get(key) / 2; ++k) {
                chars[idx++] = key;
            }
        }

        // 开始经典回溯，通过DFS实现
        boolean[] used = new boolean[size];
        dfs(chars, used, new StringBuilder(), res, ch);
        return res;
    }

    public void dfs(char[] chars,      // 我们保存的"一半"字符串，对这一半字符串做全排列
                    boolean[] used,    // 记录是否已经访问过【回溯算法的关键状态】
                    StringBuilder sb,  // 用于保存和拼接回文串之一
                    List<String> res,  // 答案
                    Character ch) {    // 如果不为null，则是原字符串中，唯一的一个奇数字符


        // 递归出口设置为 拼接字符串sb的长度等于chars时
        if (sb.length() == chars.length) {
            StringBuilder tmp = new StringBuilder(sb.toString());  // 这里需要新建一个StringBuilder
            String reverse = new StringBuilder(sb.toString()).reverse().toString();  // 需要拼接的后半段回文串，同上新建一个StringBuilder
            res.add(ch == null ? tmp.append(reverse).toString() : tmp.append(ch).append(reverse).toString());
            return;
        }
        for (int i = 0; i < chars.length; ++i) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) {
                continue;
            }
            sb.append(chars[i]);
            used[i] = true;
            dfs(chars, used, sb, res, ch);
            sb.deleteCharAt(sb.length() - 1); //回溯，删除上一步添加的元素
            used[i] = false;
        }

    }
}
