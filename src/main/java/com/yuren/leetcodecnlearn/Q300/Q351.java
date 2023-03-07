package com.yuren.leetcodecnlearn.Q300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-12-05 23:47
 */
public class Q351 {
    public int numberOfPatterns(int m, int n) {
        int[][] skip = new int[10][10];
        //这个skip数组是为了记录跳跃的点数，比如说从1到3，就跳跃2
        //而且因为是对称的操作，所以3到1也是如此
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[4][6] = skip[6][4] = skip[2][8] = skip[8][2] = 5;
        skip[1][9] = skip[9][1] = skip[3][7] = skip[7][3] = 5;
        skip[7][9] = skip[9][7] = 8;
        int result = 0;
        boolean[] visited = new boolean[10];
        //深度遍历，遍历每一个点到点的次数
        for (int i = m; i <= n; i++) {
            //因为从1,3,7,9出发都是对称的，为什么i要减一呢，因为我们是从1出发，先天少了一个节点
            result += dfs(1, visited, skip, i - 1) * 4;
            //2,4,6,8对称
            result += dfs(2, visited, skip, i - 1) * 4;
            //唯独5独立
            result += dfs(5, visited, skip, i - 1);
        }
        return result;
    }

    //深度遍历
    public int dfs(int current, boolean[] visited, int[][] skip, int remainKeyCount) {
        if (remainKeyCount == 0) {
            return 1;
        }
        int result = 0;
        //深度遍历都是渣男，做了又要反悔找下家
        visited[current] = true;

        for (int i = 1; i <= 9; i++) {
            //看当前的节点到i节点的路径中有没有其他节点在中间
            int crossThroughNumber = skip[current][i];
            //如果这一次我们的i节点没有被读过，那么就判断有没有路过中间节点(visited[crossThroughNumber])或者这两个节点相邻没有中间节点（currentThrough=0）
            if (!visited[i] && (crossThroughNumber == 0 || visited[crossThroughNumber])) {
                result += dfs(i, visited, skip, remainKeyCount - 1);
            }
        }
        //渣男行径开始了
        visited[current] = false;
        return result;
    }
}
