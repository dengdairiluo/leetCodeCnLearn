package com.yuren.leetcodecnlearn.Q2500;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-08-05 上午7:27
 */
public class Q2481 {
    private int[] edge, next, head;
    int index;
    int[] parents; //parents[i] => parent of vertex i if tree was rooted at vertex 0.
    Set<Integer>[] guessParents;
    int result = 0;

    void add(int u, int v) {
        edge[index] = v;
        next[index] = head[u];
        head[u] = index++;
    }

    public int rootCount(int[][] edges, int[][] guesses, int k) {
        int n = edges.length + 1;

        edge = new int[n << 1];
        next = new int[n << 1];
        head = new int[n];

        for (int i = 0; i < n; ++i)
            head[i] = -1;
        index = 0;
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            add(u, v);
            add(v, u);
        }

        parents = new int[n];
        findParent(0, -1);

        guessParents = new Set[n];
        for (int i = 0; i < n; i++)
            guessParents[i] = new HashSet<>();

        for (int[] g : guesses)
            guessParents[g[1]].add(g[0]);

        int correctGuesses = 0;

        for (int i = 1; i < n; i++) {
            int p = parents[i];
            if (guessParents[i].contains(p))
                correctGuesses++;
        }

        if (correctGuesses >= k)
            ++result;  //If 0 is a possible node increase answer

        for (int index = head[0]; index != -1; index = next[index]) {
            int v = edge[index];
            dfs(v, 0, correctGuesses, k);
        }

        return result;
    }

    private void findParent(int u, int parent) {

        parents[u] = parent;

        for (int index = head[u]; index != -1; index = next[index]) {
            int v = edge[index];
            if (v == parent) continue;
            findParent(v, u);
        }
    }

    private void dfs(int u, int parent, int correctGuesses, int k) {
        if (guessParents[u].contains(parent)) correctGuesses--;
        if (guessParents[parent].contains(u)) correctGuesses++;

        if (correctGuesses >= k)
            ++result;

        for (int index = head[u]; index != -1; index = next[index]) {
            int v = edge[index];
            if (v == parent) continue;
            dfs(v, u, correctGuesses, k);
        }

    }
}
