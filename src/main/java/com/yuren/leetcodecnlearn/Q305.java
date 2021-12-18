package com.yuren.leetcodecnlearn;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-11-18 23:50
 */
public class Q305 {
    public boolean G(int x, int m, int y, int n) {
        return 0 <= x && x < m && 0 <= y && y < n;
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        Union set = new Union(m * n);
        int[] vis = new int[m * n];
        List<Integer> ans;
        ans = new ArrayList<>();
        for (int[] p : positions) {
            int i = n * p[0] + p[1], nx = p[0], ny = p[1], x = 0, y = 0;
            if (vis[i] == 1) {
                ans.add(set.count);
                continue;
            }
            set.count++;
            vis[i] = 1;
            x = nx;
            y = ny + 1;
            if (G(x, m, y, n) && vis[i + 1] == 1 && !set.united(i, i + 1)) set.union(i, i + 1);
            x = nx;
            y = ny - 1;
            if (G(x, m, y, n) && vis[i - 1] == 1 && !set.united(i, i - 1)) set.union(i, i - 1);
            x = nx + 1;
            y = ny;
            if (G(x, m, y, n) && vis[i + n] == 1 && !set.united(i, i + n)) set.union(i, i + n);
            x = nx - 1;
            y = ny;
            if (G(x, m, y, n) && vis[i - n] == 1 && !set.united(i, i - n)) set.union(i, i - n);
            ans.add(set.count);
        }
        return ans;
    }

    static class Union {// 并查集模板
        int[] fa;
        int[] sz;
        int count;// 当前连通分量数目

        public Union(int n) {//构造函数+初始化
            this.sz = new int[n];
            for (int i = 0; i < n; i++) sz[i] = 1;
            this.fa = new int[n];
            for (int i = 0; i < n; i++) fa[i] = i;
            this.count = 0;
        }

        public boolean united(int x, int y) {
            x = find(x);
            y = find(y);
            return x == y;
        }

        public int find(int x) {
            return fa[x] == x ? x : (fa[x] = find(fa[x]));
        }

        public void union(int x, int y) {
            x = find(x);
            y = find(y);
            if (sz[x] < sz[y]) {
                x ^= y;
                y ^= x;
                x ^= y;
            }//按秩合并保证 sz[x]>=sz[y]
            sz[x] += sz[y];
            fa[y] = x;
            --count;//把秩小的unite到大的上
        }
    }

}
