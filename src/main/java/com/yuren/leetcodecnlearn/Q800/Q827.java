package com.yuren.leetcodecnlearn.Q800;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-06-29 23:36
 */
public class Q827 {
    /**
     * 1.第一步，先深度优先遍历出陆地，获取到所有的陆地面积，并且将同一块陆地中的格子值置换为同一索引值，该索引为记录该陆地面积的索引下标值
     * 2.第二部，遍历海洋，找到相邻陆地面积最大的海洋格子
     */
    public static int largestIsland(int[][] grid) {
        //用来记录每次遍历中每个陆地的面积大小
        int res = 0;
        int maxArea = 0;
        //索引值从2开始，避免和0（海洋）,1（陆地）值冲突
        int index = 2;
        Map<Integer, Integer> map = new HashMap<>();
        //1.深度优先，先遍历出陆地面积
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == 1) {
                    int a = area(grid, x, y, index);
                    maxArea = Math.max(a, res);
                    map.put(index, a);
                    ++index;
                }
            }
        }
        //2.遍历海洋，找到相邻陆地面积最大的海洋格子
        int plusRes = 0;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                //如果是0（海洋）
                if (grid[x][y] == 0) {
                    int plusArea = plusArea(grid, x, y, map);
                    plusRes = Math.max(plusArea, plusRes);
                }
            }
        }
        //可能都没有海洋，全是陆地，则再次判断，直接返回陆地最大值
        plusRes = Math.max(maxArea, plusRes);
        return plusRes;
    }

    private static int plusArea(int[][] grid, int x, int y, Map<Integer, Integer> map) {
        if (!isArea(grid, x, y)) {
            return 0;
        }
        if (grid[x][y] != 0) {
            return 0;
        }
        Integer size = 0;
        //叠加面积很关键的一步，记得去重，因为海洋四周接壤的土地有可能是同一块陆地
        Set<Integer> set = new HashSet<>();
        if (isArea(grid, x - 1, y) && grid[x - 1][y] >= 2) {
            set.add(grid[x - 1][y]);
        }
        if (isArea(grid, x + 1, y) && grid[x + 1][y] >= 2) {
            set.add(grid[x + 1][y]);
        }
        if (isArea(grid, x, y - 1) && grid[x][y - 1] >= 2) {
            set.add(grid[x][y - 1]);
        }
        if (isArea(grid, x, y + 1) && grid[x][y + 1] >= 2) {
            set.add(grid[x][y + 1]);
        }
        for (Integer num : set) {
            size += map.get(num);
        }
        //海洋变土地，+1
        ++size;
        return size;
    }

    private static int area(int[][] grid, int x, int y, int index) {
        if (!isArea(grid, x, y)) {
            return 0;
        }
        if (grid[x][y] != 1) {
            return 0;
        }
        //用index来代表同一块陆地存放面积的索引值
        grid[x][y] = index;
        return 1
                + area(grid, x + 1, y, index)
                + area(grid, x - 1, y, index)
                + area(grid, x, y + 1, index)
                + area(grid, x, y - 1, index);
    }

    private static boolean isArea(int[][] grid, int x, int y) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length;
    }

}
