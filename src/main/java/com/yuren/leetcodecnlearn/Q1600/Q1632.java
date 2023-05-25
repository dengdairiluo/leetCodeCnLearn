package com.yuren.leetcodecnlearn.Q1600;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-05-25 23:54
 */
public class Q1632 {
    public int[][] matrixRankTransform(int[][] matrix) {
        int ylen = matrix.length, xlen = matrix[0].length;
        int[][] ans = new int[ylen][xlen];

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();

        for (int y = 0, index = 0; y < ylen; y++) {
            for (int x = 0; x < xlen; x++, index++) {
                map.computeIfAbsent(matrix[y][x], (i) -> new ArrayList<Integer>())
                        .add(index);
            }
        }
        // console.log(map);


        int[] rank = new int[ylen + xlen];
        Arrays.fill(rank, 0);

        int[] cur = new int[ylen + xlen];
        Arrays.fill(rank, 0);

        int[] link = new int[ylen + xlen];

        for (List<Integer> list : map.values()) {
            // console.log(list);

            for (int i = link.length - 1; i >= 0; i--) {
                link[i] = i;
            }

            // 并集查找出关联的最大值
            for (int index : list) {
                int right = index / xlen + xlen;
                int left = index % xlen;
                int rightRoot = find(link, right);
                int leftRoot = find(link, left);
                link[rightRoot] = leftRoot;
                cur[leftRoot] = Math.max(Math.max(cur[rightRoot], cur[leftRoot]), Math.max(rank[right], rank[left]));
            }
            // console.log(Arrays.toString(link));

            // 写入答案，更新排名
            for (int index : list) {
                int y = index / xlen;
                int x = index % xlen;
                int right = y + xlen;
                int root = find(link, right);
                ans[y][x] = cur[root] + 1;
                rank[x] = cur[root] + 1;
                rank[right] = cur[root] + 1;
            }

        }

        return ans;
    }

    public int find(int[] links, int root) {
        if (links[root] == root) {
            return root;
        }
        return links[root] = find(links, links[root]);
    }
}
