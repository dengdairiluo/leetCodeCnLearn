package com.yuren.leetcodecnlearn.Q1600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-06-17 23:13
 */
public class Q1697 {
    int inf = 10000000;
    int[] r, cs, dis;

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        int le = edgeList.length;
        quicksort1(edgeList, 0, le - 1);
        int m = queries.length;
        r = new int[n];
        cs = new int[n];
        dis = new int[n];
        for (int i = 0; i < n; i++) {
            r[i] = i;
        }
        for (int[] x : edgeList) {
            union(x[0], x[1], x[2]);
        }
        boolean[] res = new boolean[m];
        int p = 0;
        for (int i = 0; i < m; i++) {
            int[] y = queries[i];
            res[i] = root(y[0], y[2]) == root(y[1], y[2]);
        }
        return res;
    }

    public int root(int x, int d) {
        if (r[x] == x) {
            return x;
        }
        if (dis[x] >= d) {
            return x;
        }
        return root(r[x], d);
    }

    public void union(int x, int y, int d) {
        // System.out.println(x+":"+y);
        int r1 = root(x, inf);
        //  System.out.println(x+":"+y+"\t"+r1+":"+r1);
        int r2 = root(y, inf);
        if (r1 != r2) {
            if (cs[r1] > cs[r2]) {
                r[r2] = r1;
                dis[r2] = d;
            } else if (cs[r1] < cs[r2]) {
                r[r1] = r2;
                dis[r1] = d;
            } else {
                r[r2] = r1;
                dis[r2] = d;
                cs[r1]++;
            }
        }
    }

    public void quicksort1(int[][] edgeList, int low, int high) {
        int l = low, r = high;
        int[] temp = edgeList[l];
        if (r - l > 4) {
            int m = r + l >> 1;
            int b = edgeList[m][2];
            int c = edgeList[r][2];
            int mid = temp[2] >= b ? (b >= c ? m : (temp[2] > c ? r : l)) : (temp[2] >= c ? l : (b > c ? r : m));
            if (mid != l) {
                temp = edgeList[mid];
                edgeList[mid] = edgeList[l];
            }
        }
        while (l < r) {
            while (l < r && edgeList[r][2] >= temp[2]) {
                r--;
            }
            if (l >= r) {
                break;
            }
            edgeList[l++] = edgeList[r];
            while (l < r && edgeList[l][2] <= temp[2]) {
                l++;
            }
            if (l < r) {
                edgeList[r--] = edgeList[l];
            }
        }
        edgeList[l] = temp;
        if (low + 1 < l - 1) {
            quicksort1(edgeList, low, l - 1);
        }
        if (high > l + 1) {
            quicksort1(edgeList, l + 1, high);
        }
    }
}
