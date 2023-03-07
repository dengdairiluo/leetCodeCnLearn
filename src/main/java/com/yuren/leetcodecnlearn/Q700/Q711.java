package com.yuren.leetcodecnlearn.Q700;

import java.util.HashSet;
import java.util.Set;

public class Q711 {
    /**
     * 审题：J 代表宝石的类型，字母不重复；S 是你拥有的石头
     * 题目意思问你在这堆石头有多少个宝石？
     * 解法：
     * (1) 暴力法
     * (2) 哈希判断
     * (3) ASCII
     */

    // 暴力法
    public int numJewelsInStones1(String J, String S) {
        int res = 0;
        // 遍历你拥有的石头
        for (int i = 0; i < S.length(); i++) {
            // 遍历宝石的类型
            for (int j = 0; j < J.length(); j++) {
                // 如果当前拥有的石头和宝石类型匹配上了，则数量++
                if (S.charAt(i) == J.charAt(j)) {
                    res++;
                }
            }
        }
        return res;
    }

    // 哈希判断
    public int numJewelsInStones2(String J, String S) {
        int res = 0;
        Set<Character> set = new HashSet<>();
        // 遍历宝石类型，存放到哈希表进行判断
        for (char ch : J.toCharArray()) {
            set.add(ch);
        }
        // 遍历你拥有的石头
        for (char ch : S.toCharArray()) {
            // 如果哈希表存在该类型宝石
            if (set.contains(ch)) {
                res++;
            }
        }
        return res;
    }

    /**
     * ASCII
     * a-z : 97-122
     * A-Z : 65-90
     * A-z : 65-122 => 58 (大小写字母ascii码跨度最大为58))
     */
    public int numJewelsInStones(String J, String S) {
        int res = 0;
        // 声明一个58的数组
        char[] chars = new char[58];
        // 与哈希表对比，这里存放在一个数组进行比对
        for (char ch : J.toCharArray()) {
            // 所有字母减去65得出数组下标，并++
            chars[ch - 65]++;
        }
        // 遍历你拥有的石头
        for (char ch : S.toCharArray()) {
            // 如果等于1，说明存在宝石
            if (chars[ch - 65] == 1) {
                res++;
            }
        }
        return res;
    }
}
