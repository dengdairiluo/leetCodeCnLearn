package com.yuren.leetcodecnlearn.Q200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-11-09 23:10
 */
public class Q279 {
    public int numSquares(int n) {
        // pair.first表示当前数字，pair.second表示移动了多少步
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        // 用于记录已经访问过的点，避免多次重复访问
        boolean[] visited = new boolean[n + 1];
        // 将n入队
        queue.offer(new Pair<>(n, 0));
        visited[n] = true;
        // 下面用广度优先遍历，找到从 n节点到 0节点的最短路径
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            int num = pair.first;
            int step = pair.second;

            if (num == 0) {
                return step;
            }

            //找出所有小余num的a，并且num和a的差值是一个完全平方数
            for (int i = 1; ; i++) {
                int a = num - i * i;
                if (a < 0) {
                    break;
                }
                //如果该值没有被访问过，则入队。
                if (!visited[a]) {
                    queue.offer(new Pair<>(a, step + 1));
                    visited[a] = true;
                }
            }
        }
        return 0;
    }

    private static class Pair<F, S> {
        F first;
        S second;

        Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }
}
