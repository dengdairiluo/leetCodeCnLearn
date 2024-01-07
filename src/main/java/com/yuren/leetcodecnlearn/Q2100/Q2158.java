package com.yuren.leetcodecnlearn.Q2100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-01-07 22:03
 */
public class Q2158 {
    static int[] parent = new int[50001];

    public int[] amountPainted(int[][] paint) {
        int n = paint.length;

        int[] ans = new int[n];

        for (int i = 1; i <= 50000; i++)
            parent[i] = i;

        for (int i = 0; i < n; i++) {
            int count = 0;
            int a = paint[i][0], b = paint[i][1];
            a = find(a);
            b = find(b);
            for (int x = b; x != a; x = find(x)) {
                parent[x] = find(x - 1);
                count++;
            }
            ans[i] = count;
        }
        return ans;

    }

    int find(int x) {
        return x == parent[x] ? x : (parent[x] = find(parent[x]));
    }
}
