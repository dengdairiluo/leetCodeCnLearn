package com.yuren.leetcodecnlearn.Q2400;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-05-18 下午11:36
 */
public class Q2421 {
    //首先根据边的两端点的最大值对边进行排序
    //再遍历每一条边，由于树为连通无向无环的图，则这两个节点必为不同集合中的点
    //判断两端点各自在的集合中的最大值是否相等，有多少个，求出好路径条数
    public static int[] father;
    //把值最大的节点设置为代表节点，存储每个集合中代表节点的值的个数，索引为代表节点的索引
    public static int[] maxCnt;
    public static int ans;

    public static void build(int n, int[] vals) {
        father = new int[n];
        maxCnt = new int[n];//集合的最大值，个数
        ans = 0;
        for (int i = 0; i < n; i++) {
            father[i] = i;
            maxCnt[i] = 1;
        }
    }

    public static int find(int i) {
        if (i != father[i]) {
            father[i] = find(father[i]);
        }
        return father[i];
    }

    public static void union(int index1, int index2, int[] vals) {
        int f1 = find(index1);
        int f2 = find(index2);
        if (vals[f1] == vals[f2]) {
            ans += maxCnt[f1] * maxCnt[f2];
            maxCnt[f1] += maxCnt[f2];
            father[f2] = f1;
        } else if (vals[f1] > vals[f2]) {
            father[f2] = f1;
        } else {
            father[f1] = f2;
        }
    }

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;
        build(n, vals);
        Arrays.sort(edges, Comparator.comparingInt(a -> Math.max(vals[a[0]], vals[a[1]])));
        for (int i = 0; i < n - 1; i++) {
            union(edges[i][0], edges[i][1], vals);
        }
        return ans + n;
    }
}
