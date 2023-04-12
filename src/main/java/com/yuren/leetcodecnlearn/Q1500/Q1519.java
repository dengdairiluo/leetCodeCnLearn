package com.yuren.leetcodecnlearn.Q1500;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-04-12 23:29
 */
public class Q1519 {

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<Integer>[] nexts = new ArrayList[n];
        for (int i = 0; i < nexts.length; i++) {
            nexts[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            int a = e[0], b = e[1];
            nexts[a].add(b);
            nexts[b].add(a);
        }
        int[] ans = new int[n];
        this.f(0, -1, nexts, ans, labels);
        return ans;
    }

    private int[] f(int index, int p, List<Integer>[] nexts, int[] ans, String labels) {
        char cur = labels.charAt(index);
        List<Integer> next = nexts[index];
        int[] hash = new int[26];
        for (int n : next) {
            if (n != p) {
                int[] tmp = this.f(n, index, nexts, ans, labels);
                for (int i = 0; i < 26; i++) {
                    hash[i] += tmp[i];
                }
            }
        }
        ans[index] = ++hash[cur - 'a'];
        return hash;
    }

}
