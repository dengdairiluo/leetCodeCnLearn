package com.yuren.leetcodecnlearn.Q1400;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-03-27 22:59
 */
public class Q1489 {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            ans.add(new ArrayList<>());
        }
        int maxWeight = 1001;
        // 角标为权值, List为对应权值的所有边
        List<Integer>[] weightList = new List[maxWeight];
        for (int i = 0; i < maxWeight; i++) {
            weightList[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            weightList[edges[i][2]].add(i);
        }
        ArrayUnionFind unionFind = new ArrayUnionFind(n);
        for (int i = 0; i < maxWeight; i++) {
            List<Integer> value = weightList[i];
            List<Integer> list = new ArrayList<>();
            // 排除掉非关建边
            for (Integer index : value) {
                int[] edge = edges[index];
                int p = unionFind.find(edge[0]);
                int q = unionFind.find(edge[1]);
                if (p == q) {
                    continue;
                }
                list.add(index);
            }
            // 克隆一个union之前的并查集
            ArrayUnionFind clone = (ArrayUnionFind) unionFind.clone();
            // 将该权值的边连接的点全部union
            for (Integer index : value) {
                unionFind.union(edges[index][0], edges[index][1]);
            }
            for (Integer index : list) {
                ArrayUnionFind cloneUnionFind = (ArrayUnionFind) clone.clone();
                // 除了当前index的边，全部union
                for (Integer index2 : value) {
                    if (index.equals(index2)) {
                        continue;
                    }
                    cloneUnionFind.union(edges[index2][0], edges[index2][1]);
                }
                if (unionFind.size == cloneUnionFind.size) {
                    // 如果当前边的union不对size产生影响，则为伪关键边
                    ans.get(1).add(index);
                } else {
                    // 如果当前边的union对size产生影响，则为关键边
                    ans.get(0).add(index);
                }
            }
            // 全部合并完成
            if (unionFind.size == 1) {
                break;
            }
        }
        return ans;
    }

    private static class ArrayUnionFind implements Cloneable {
        int[] roots;
        /**
         * 集合数量
         */
        int size;

        public ArrayUnionFind(int n) {
            roots = new int[n];
            for (int i = 0; i < n; i++) {
                roots[i] = i;
            }
            size = n;
        }

        public int find(int i) {
            if (i == roots[i]) {
                return i;
            }
            return roots[i] = find(roots[i]);
        }

        public void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot != qRoot) {
                roots[pRoot] = qRoot;
                size--;
            }
        }

        @Override
        protected Object clone() {
            ArrayUnionFind unionFind = new ArrayUnionFind(this.roots.length);
            unionFind.size = this.size;
            System.arraycopy(roots, 0, unionFind.roots, 0, roots.length);
            return unionFind;
        }
    }


}

