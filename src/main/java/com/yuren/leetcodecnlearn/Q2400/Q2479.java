package com.yuren.leetcodecnlearn.Q2400;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-06-15 下午11:58
 */
public class Q2479 {
    long[] sums;
    Set<Integer>[] graph;
    int[] values;

    public long maxXor(int n, int[][] edges, int[] values) {
        graph = new HashSet[n];
        Arrays.setAll(graph, o -> new HashSet<>());
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        sums = new long[n];
        this.values = values;
        maxXor(0, -1);
        return max;
    }

    long max = 0L;

    private Tire maxXor(int root, int parent) {
        int size = parent == -1 ? graph[root].size() : graph[root].size() - 1;
        sums[root] = values[root];
        Tire t = new Tire();
        if (size > 0) {
            for (int next : graph[root]) {
                if (next == parent) continue;
                Tire nextTire = maxXor(next, root);
                max = Math.max(max, t.findXorMax(t, nextTire));
                t.add(nextTire);
                sums[root] += sums[next];
            }
        }
        t.add(sums[root]);
        return t;
    }

    class Tire {
        Tire[] child = new Tire[2];
        boolean isEnd;

        public void add(long val) {
            String str = getStr(val);
            Tire curr = this;
            for (int i = 0; i < str.length(); i++) {
                int index = str.charAt(i) - '0';
                if (curr.child[index] == null) {
                    curr.child[index] = new Tire();
                }
                curr = curr.child[index];
            }
            curr.isEnd = true;
        }

        public void add(Tire b) {
            Tire a = this;
            for (int i = 0; i < 2; i++) {
                if (b.child[i] != null) {
                    if (a.child[i] != null) {
                        a.child[i].add(b.child[i]);
                    } else a.child[i] = b.child[i];
                }
            }
        }

        public long findXorMax(Tire a, Tire b) {
            if (a.child[0] == null && a.child[1] == null) return 0L;
            String max = findXorStrMax(a, b);
            return Long.parseLong(max, 2);
        }

        private String findXorStrMax(Tire a, Tire b) {
            String ans = "";
            //10 01 00 11
            for (int diff = 1; diff >= 0; diff--) {
                for (int i = 0; i < 2; i++) {
                    int j = (i + diff) % 2;
                    if (a.child[i] == null || b.child[j] == null) continue;
                    String pre = String.valueOf(diff);
                    String next = pre + findXorStrMax(a.child[i], b.child[j]);
                    ans = ans.compareTo(next) > 0 ? ans : next;
                }

                if (!ans.equals("")) break;
            }
            return ans;
        }

        private String getStr(long val) {
            String str = Long.toBinaryString(val);
            String preZero = "0000000000000000000000000000000000000000000000000000000000000000";
            return preZero.substring(0, 47 - str.length()) + str;
        }
    }
}
