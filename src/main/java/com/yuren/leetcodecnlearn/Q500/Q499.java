package com.yuren.leetcodecnlearn.Q500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-02-06 22:42
 */
public class Q499 {

    /**
     * 方向
     * x,y-1
     * x-1,y  xy  x+1,y
     * x,y+1
     */
    public int[][] directs = new int[][]{{1, 0}, {0, -1}, {0, 1}, {-1, 0}, {0, 0}};
    /**
     * 路径
     */
    public String[] paths = new String[]{"d", "l", "r", "u"};

    /**
     * 遇到墙壁前不会停止滚动,递归四个方向
     */
    public int bfs(int[][] maze, Node cur, Node[] q, int s, boolean[][][] visited) {
        //记录走过
        visited[cur.row][cur.col][cur.direct] = true;
        //当前方向
        int d = cur.direct;
        int nextRow = cur.row + directs[d][0];
        //新的行列位置
        int nextCol = cur.col + directs[d][1];
        //越界，障碍，已经走过
        if (d == 4 || nextRow < 0 || nextRow >= maze.length || nextCol < 0 || nextCol >= maze[0].length || maze[nextRow][nextCol] != 0 || visited[nextRow][nextCol][d]) {
            //尝试其他4个方向,去掉当前方向
            for (int i = 0; i < 4; i++) {
                if (i != d) {
                    nextRow = cur.row + directs[i][0];
                    //新的行列位置
                    nextCol = cur.col + directs[i][1];
                    if (nextRow >= 0 && nextRow < maze.length && nextCol >= 0 && nextCol < maze[0].length && maze[nextRow][nextCol] == 0 && !visited[nextRow][nextCol][i]) {
                        //走其他方向
                        Node newNode = new Node(nextRow, nextCol, i, cur.path + paths[i]);
                        //加入下一个队列
                        q[s++] = newNode;

                    }

                }
            }


        } else {
            //方向不变，路径不变
            Node newNode = new Node(nextRow, nextCol, d, cur.path);
            //加入下一个队列
            q[s++] = newNode;

        }

        //记录位置BFS队列有效大小
        return s;

    }

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int N = maze.length;
        //记录长度，宽度
        int M = maze[0].length;
        //记录广度遍历节点
        Node[] q1 = new Node[N * M + 1];
        //循环检测
        Node[] q2 = new Node[N * M + 1];
        int s1 = 0;
        int s2 = 0;
        //上下左右，当下
        boolean[][][] visited = new boolean[N][M][5];
        //广度遍历所有可能
        s1 = bfs(maze, new Node(ball[0], ball[1], 4, ""), q1, s1, visited);
        //交错查找
        while (s1 > 0) {
            for (int i = 0; i < s1; i++) {
                //取得当前节点
                Node cur = q1[i];
                if (cur.row == hole[0] && cur.col == hole[1]) {
                    //掉进洞中
                    return cur.path;
                }
                s2 = bfs(maze, cur, q2, s2, visited);
            }
            //交换
            Node[] temp = q1;
            q1 = q2;
            q2 = temp;
            s1 = s2;
            s2 = 0;

        }

        return "impossible";
    }

    private static class Node {
        public int row; //行
        public int col; //列
        public int direct; //方向
        public String path;//路径

        public Node(int row, int col, int direct, String path) { //节点
            this.row = row;
            this.col = col;
            this.direct = direct;
            this.path = path;

        }

    }

}
