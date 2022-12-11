package com.yuren.leetcodecnlearn.Q500;

import java.util.List;

public class Q444 {

    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        //记录长度
        int n = nums.length;
        //位置
        int[] pos = new int[n + 1];
        for (int i = 0; i < n; i++) {
            //记录位置
            pos[nums[i]] = i;
        }
        //标记是否访问
        boolean[] visited = new boolean[n];
        //循环序列
        for (List<Integer> sq : sequences) {
            //标记位置
            int prepos = -1;
            //循环序列
            for (int cur : sq) {
                //取得当前字符
                if (cur > n || cur < 1) {
                    //数据越界
                    return false;
                }
                //获取当前位置
                int curpos = pos[cur];
                if (prepos >= curpos) {
                    //位置过了
                    return false;
                }
                if (prepos + 1 == curpos) {
                    //访问过了，重合
                    visited[cur - 1] = true;
                }

                //遍历每一个
                prepos = curpos;

            }
        }

        for (boolean visit : visited) {
            if (!visit) {
                //不可重建
                return false;
            }
        }

        //返回真
        return true;

    }
}
