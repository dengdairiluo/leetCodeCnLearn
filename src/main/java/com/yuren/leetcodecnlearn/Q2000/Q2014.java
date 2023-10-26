package com.yuren.leetcodecnlearn.Q2000;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-10-26 23:47
 */
public class Q2014 {
    private final Map<Character, TreeSet<Integer>> map = new HashMap<>();
    private char[] usableChars;
    private char[] source;


    public String longestSubsequenceRepeatedK(String s, int k) {
        int len = s.length();
        // len < 8 * k
        // 子序列最长为7
        int[] count = new int[26];
        source = s.toCharArray();
        for (char c : source) {
            count[c - 'a']++;
        }
        // 获取个数超过 k 的 字符,每增加k个 额外录入一个
        char[] exists = new char[len / k];
        int idx = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] >= k) {
                exists[idx++] = (char) (i + 'a');
                count[i] -= k;
            }
        }
        if (idx == 0) return "";
        // 根据 exists 进行 处理 bfs
        usableChars = Arrays.copyOf(exists, idx);
        return process(k);
    }


    private String process(int k) {
        Queue<Tup> queue = new ArrayDeque<>();
        for (int i = 0; i < usableChars.length; i++) {
            if (i > 0 && usableChars[i] == usableChars[i - 1]) continue;
            int visit = 1 << i;
            queue.add(new Tup(String.valueOf(usableChars[i]), visit));
        }
        String ans = String.valueOf(usableChars[usableChars.length - 1]);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Tup r = queue.remove();
                String remove = r.cur;
                int visit = r.visit;
                int cnt = repeatCountNew(remove);
                if (cnt >= k) {
                    ans = remove;
                    // 在 visit 的基础上, 再次挑选出一个合适的字符
                    for (int j = 0; j < usableChars.length; j++) {
                        if (((1 << j) & visit) == 0) {
                            // visit 当前位置 为 0
                            queue.add(new Tup(remove + usableChars[j], visit | (1 << j)));
                        }
                    }
                }
            }
        }
        return ans;

    }


    private static class Tup {
        private String cur;
        private int visit;

        Tup(String cur, int visit) {
            this.cur = cur;
            this.visit = visit;
        }
    }

    private int repeatCountNew(String reg) {
        char[] chars = reg.toCharArray();
        int regIdx = 0;
        int cnt = 0;
        for (char s : source) {
            if (s == chars[regIdx]) {
                regIdx++;
            }
            if (regIdx == chars.length) {
                cnt++;
                regIdx = 0;
            }
        }
        return cnt;
    }

    private int repeatCount(String reg) {
        char[] chars = reg.toCharArray();
        int pre = -1;
        boolean stop = false;
        int term = 0;
        while (!stop) {
            for (char c : chars) {
                TreeSet<Integer> treeSet = map.get(c);
                Integer curPre = treeSet.higher(pre);
                if (curPre == null) {
                    stop = true;
                    break;
                }
                pre = curPre;
            }
            if (!stop) {
                term++;
            }
        }
        return term;
    }
}
