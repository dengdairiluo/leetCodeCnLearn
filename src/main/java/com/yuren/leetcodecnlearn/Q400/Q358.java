package com.yuren.leetcodecnlearn.Q400;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q358 {
    public String rearrangeString(String s, int k) {
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> map[o2] - map[o1]);
        StringBuilder ans = new StringBuilder();
        Queue<Integer> temp = new LinkedList<>();
        for (int i = 0; i < map.length; i++) {
            if (map[i] > 0) heap.add(i);
        }
        while (!heap.isEmpty()) {
            int curr = heap.poll();
            temp.add(curr);
            map[curr]--;
            ans.append((char) ('a' + curr));
            if (temp.size() >= k) {
                int mem = temp.poll();
                if (map[mem] > 0) heap.offer(mem);
            }
        }

        return ans.length() == s.length() ? ans.toString() : "";
    }
}
