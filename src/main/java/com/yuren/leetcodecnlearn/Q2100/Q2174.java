package com.yuren.leetcodecnlearn.Q2100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-01-14 22:58
 */
public class Q2174 {
    private int ans;

    public int removeOnes(int[][] grid) {
        // 为了节省空间，用1个数字表示坐标点
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    list.add(i * 16 + j);
                }
            }
        }
        // 递归处理所有可能情况，返回最小操作次数
        ans = Integer.MAX_VALUE;
        dfs(list, 0);
        return ans;
    }

    // 递归函数含义：剩余'1'的坐标列表为list，已经执行了step步，遍历当前删除各个'1'的情况
    public void dfs(List<Integer> list, int step) {
        // 数组中不在有1时，取最小操作次数返回
        if (list.isEmpty()) {
            ans = Math.min(ans, step);
            return;
        }
        // 遍历list中所有的1，针对每个1都删掉行列的1之后再继续递归
        int size = list.size();
        for (int k = 0; k < size; k++) {
            int i = list.get(k) / 16;
            int j = list.get(k) % 16;
            List<Integer> newList = new ArrayList<>();
            for (int num : list) {
                if (num / 16 != i && num % 16 != j) {
                    newList.add(num);
                }
            }
            dfs(newList, step + 1);
        }
    }
}
