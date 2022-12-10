package com.yuren.leetcodecnlearn.Q300;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-11-04 23:13
 */
public class Q269 {
    boolean[][] edge = new boolean[26][26];
    int[] degree = new int[26];

    private void setDegree(String s) {
        for (int i = 0; i < s.length(); i++) {
            degree[s.charAt(i) - 'a'] = Math.max(degree[s.charAt(i) - 'a'], 0);
        }
    }

    private boolean findDiff(String a, String b) {
        for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
            if (a.charAt(i) == b.charAt(i)) {
                continue;
            }
            if (!edge[a.charAt(i) - 'a'][b.charAt(i) - 'a']) {
                edge[a.charAt(i) - 'a'][b.charAt(i) - 'a'] = true;
                degree[b.charAt(i) - 'a']++;
            }
            return true;
        }
        return a.length() <= b.length();
    }

    public String alienOrder(String[] words) {
        Arrays.fill(degree, -1);
        setDegree(words[0]);
        for (int i = 0; i < words.length - 1; i++) {
            setDegree(words[i + 1]);
            if (!findDiff(words[i], words[i + 1])) {
                return "";
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int curLetter = queue.poll();
            sb.append((char) ('a' + curLetter));
            for (int nextLetter = 0; nextLetter < edge[curLetter].length; nextLetter++) {
                if (!edge[curLetter][nextLetter]) {
                    continue;
                }
                if (--degree[nextLetter] == 0) {
                    queue.offer(nextLetter);
                }
            }
            Arrays.fill(edge[curLetter], false);
        }
        for (int i : degree) {
            if (i > 0) {
                return "";
            }
        }
        return sb.toString();
    }
}
