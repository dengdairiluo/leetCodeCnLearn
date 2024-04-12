package com.yuren.leetcodecnlearn.Q600;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-04-24 07:04
 */
public class Q675 {
    public int cutOffTree(List<List<Integer>> forest) {
        int M = forest.size(), N = forest.get(0).size();

        // 未坎数节点
        PriorityQueue<Point> queue = new PriorityQueue<>(Comparator.comparingInt(p -> p.height));
        for (int i = 0; i < M; i++) {
            List<Integer> rows = forest.get(i);
            for (int j = 0; j < N; j++) {
                int height = rows.get(j);
                if (height > 1) {
                    queue.offer(new Point(i, j, height));
                }
            }
        }

        int total = 0;
        // 人的起点
        Point pre = new Point(0, 0, forest.get(0).get(0));
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            int dist = distance(forest, pre, cur);
            if (dist == -1) {
                return -1;
            }
            total += dist;
            //System.out.println(pre.height +  " > " + cur.height + " : " + dist);
            pre = cur;
        }

        return total;
    }

    // bfs 求节点之间的距离
    public int distance(List<List<Integer>> forest, Point source, Point dest) {
        int M = forest.size(), N = forest.get(0).size();
        if (null == source || source.height == dest.height) {
            return 0;
        }

        LinkedList<Point> deque = new LinkedList<>();
        boolean[][] visited = new boolean[M][N];
        deque.offer(source);
        visited[source.x][source.y] = true;

        boolean found = false;
        int dist = 0;
        int[] directions = {-1, 0, 1, 0, -1};
        while (!deque.isEmpty() && !found) {
            int size = deque.size();
            for (int i = 0; i < size && !found; i++) {
                Point cur = deque.poll();
                for (int t = 0; t < 4; t++) {
                    int x = cur.x + directions[t];
                    int y = cur.y + directions[t + 1];

                    if (x >= 0 && x < M && y >= 0 && y < N && !visited[x][y]) {
                        int height = forest.get(x).get(y);
                        if (height == dest.height) {
                            found = true;
                            break;
                        }

                        if (height > 0) {
                            deque.offer(new Point(x, y, height));
                            visited[x][y] = true;
                        }
                    }
                }
            }

            dist++;
        }


        return found ? dist : -1;
    }

    private static class Point {
        int x;
        int y;
        int height;

        public Point(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }
}
