package com.yuren.leetcodecnlearn.Q2000;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-11-10 23:52
 */
public class Q2045 {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        // 每条边的权重是一样的，所以，我们只需要找到次短路就可以了
        // 一样使用BFS，一层一层的遍历，第二次遇到 n 才结束

        // 先构造 n 个节点
        Node[] nodes = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node();
        }

        // 整理边，设置到 Node 的 nexts 中
        for (int[] edge : edges) {
            nodes[edge[0]].nexts.add(nodes[edge[1]]);
            nodes[edge[1]].nexts.add(nodes[edge[0]]);
        }

        // BFS使用的队列
        Queue<Node> queue = new LinkedList<>();

        // 先把第 1 个节点入队，并设置其访问次数为 1
        queue.offer(nodes[1]);
        nodes[1].visited++;

        // ans 为返回的答案
        int ans = 0;
        // 遍历的层级，与二叉树的层序遍历类似
        int level = 0;
        while (!queue.isEmpty()) {
            // 层级加一
            level++;

            // 计算时间
            if (ans % (2 * change) >= change) {
                ans += 2 * change - ans % (2 * change);
            }
            ans += time;

            // 一层一层的遍历
            int size = queue.size();
            while (size-- > 0) {
                // 弹出当前层的节点
                Node node = queue.poll();

                // 遍历其下级的节点
                for (Node next : node.nexts) {
                    // 如果下级节点有等于 n 的，并且不是初始状态，并且不等于当前层级
                    // 说明之前已经遍历过一次了，那就直接返回吧
                    if (next == nodes[n] && next.level != 0 && next.level != level) {
                        return ans;
                    }
                    // 剪枝1：同一个层级同一个节点出现多次，只需要入队一次
                    // 剪枝2：同一个节点被访问了两次及以上（同一层级多次算一次），它肯定不可能是次短路径的一部分
                    if (next.level != level && next.visited < 2) {
                        queue.offer(next);
                        next.level = level;
                        next.visited++;
                    }
                }
            }

        }

        return -1;
    }

    static class Node {
        /**
         * 记录从起点到该点的层级
         */
        int level = 0;
        /**
         * 记录该点相连的节点
         */
        List<Node> nexts = new ArrayList<>();
        /**
         * 记录被访问过几次，同一个节点在同一层级被访问多次算一次
         */
        int visited = 0;
    }
}
