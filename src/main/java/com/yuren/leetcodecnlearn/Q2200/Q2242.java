package com.yuren.leetcodecnlearn.Q2200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-02-17 22:44
 */
public class Q2242 {
    public int maximumScore(int[] scores, int[][] edges) {
        int n = scores.length;
        int[][] nei = new int[n][3];
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            updateNei(scores, nei, u, v);
            updateNei(scores, nei, v, u);
        }
        int ans = -1;
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int t = scores[u] + scores[v];
            int i = (nei[u][0] - 1 == v) ? 1 : 0;
            int j = nei[v][0] - 1 == u ? 1 : 0;
            if (nei[u][i] == 0 || nei[v][j] == 0) {
                continue;
            }
            t += scores[nei[u][i] - 1] + scores[nei[v][j] - 1];
            if (nei[u][i] == nei[v][j]) {
                t -= scores[nei[u][i] - 1];
                i = nei[u][i + 1] - 1 == v ? i + 2 : i + 1;
                j = nei[v][j + 1] - 1 == u ? j + 2 : j + 1;
                int next = 0;
                if (i < 3 && nei[u][i] > 0) {
                    next = scores[nei[u][i] - 1];
                }
                if (j < 3 && nei[v][j] > 0) {
                    next = Math.max(next, scores[nei[v][j] - 1]);
                }
                if (next == 0) {
                    continue;
                }
                t += next;
            }
            ans = Math.max(ans, t);
        }
        return ans;
    }

    private void updateNei(int[] scores, int[][] nei, int u, int v) {
        if (nei[u][0] == 0 || scores[v] > scores[nei[u][0] - 1]) {
            nei[u][2] = nei[u][1];
            nei[u][1] = nei[u][0];
            nei[u][0] = v + 1;
        } else if (nei[u][1] == 0 || scores[v] > scores[nei[u][1] - 1]) {
            nei[u][2] = nei[u][1];
            nei[u][1] = v + 1;
        } else if (nei[u][2] == 0 || scores[v] > scores[nei[u][2] - 1]) {
            nei[u][2] = v + 1;
        }
    }
}
