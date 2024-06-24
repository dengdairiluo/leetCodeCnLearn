package com.yuren.leetcodecnlearn.Q2400;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-06-24 下午11:52
 */
public class Q2497 {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        // 构造邻接节点矩阵，index=节点编号，value=相邻节点的值列表
        List<List<Integer>> vAdjList = new ArrayList<>();
        for (int i = 0; i < vals.length; i++) {
            vAdjList.add(new ArrayList<>());
        }
        for (int[] edg : edges) {
            // 无向图，分别从前后访问，构建两次，且只保留正整数
            int starVIndex = edg[0];
            int adjVVal = vals[edg[1]];
            if (adjVVal > 0) {
                vAdjList.get(starVIndex).add(adjVVal);
            }
            starVIndex = edg[1];
            adjVVal = vals[edg[0]];
            if (adjVVal > 0) {
                vAdjList.get(starVIndex).add(adjVVal);
            }
        }

        int maxStarSum = Integer.MIN_VALUE;
        // 遍历每个中心节点，求星和
        for (int i = 0; i < vAdjList.size(); i++) {
            // 星和，包含中心节点
            int starSum = vals[i];
            List<Integer> adjVVLs = vAdjList.get(i);
            // 从大到小排序
            adjVVLs.sort((a, b) -> {
                return b - a;
            });
            // topK求和
            for (int j = 0; j < k && j < adjVVLs.size(); j++) {
                starSum += adjVVLs.get(j);
            }
            // 更新最大值
            if (starSum > maxStarSum) {
                maxStarSum = starSum;
            }
        }

        return maxStarSum;
    }
}
