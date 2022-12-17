package com.yuren.leetcodecnlearn.Q900;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-07-26 20:49
 */
public class Q886 {
    /**
     * leetcode: 可能的二分
     * 深度优先搜索+二分着色判断
     * 考虑由给定的 “不喜欢” 边缘形成的 N 人的图表。我们要检查这个图的每个连通分支是否为二分的。
     * <p>
     * 对于每个连通的部分，我们只需试着用两种颜色对它进行着色，就可以检查它是否是二分的。
     * 如何做到这一点：将任一结点涂成红色，然后将它的所有邻居都涂成蓝色，然后将所有的邻居的邻居都涂成红色，
     * 以此类推。如果我们将一个红色结点涂成蓝色（或蓝色结点涂成红色），那么就会产生冲突。
     */
    public boolean possibleBipartition(int n, int[][] dislikes) {
        //边的集合转换为邻接表,从1开始
        ArrayList<Integer>[] adjList = new ArrayList[n + 1];
        for (int i = 0; i <= n; ++i) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] edge : dislikes) {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }
        //两者颜色可以用布尔值，如true-red,false-blue
        Map<Integer, Boolean> colorMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            //没有着色
            if (!colorMap.containsKey(i)) {
                if (!dfs(adjList, colorMap, i, true)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(ArrayList<Integer>[] adjList, Map<Integer, Boolean> colorMap, int u, boolean nextColor) {
        //如果下一个结点已经标记过，则检查颜色是否冲突
        if (colorMap.containsKey(u)) {
            return colorMap.get(u) == nextColor;
        }
        colorMap.put(u, nextColor);
        for (int nextVertex : adjList[u]) {
            //相邻的点，需要颜色不同
            if (!dfs(adjList, colorMap, nextVertex, !nextColor)) {
                return false;
            }
        }
        return true;
    }
}
