package com.yuren.leetcodecnlearn.Q1700;

import java.util.ArrayList;
import java.util.List;


/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-06-28 06:22
 */
public class Q1728 {
    private final int MOUSE_TURN = 0, CAT_TURN = 1;
    private List<Integer>[][] graphs = new List[2][];
    private int foodPos;
    private int[][][] memo;

    public boolean canMouseWin(String[] grid, int catJump, int mouseJump) {
        int m = grid.length, n = grid[0].length();
        int mousePos = 0, catPos = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == 'F') {
                    foodPos = i * n + j;
                } else if (c == 'C') {
                    catPos = i * n + j;
                } else if (c == 'M') {
                    mousePos = i * n + j;
                }
            }
        }
        graphs[0] = buildGraph(mouseJump, grid);
        graphs[1] = buildGraph(catJump, grid);
        memo = new int[m * n][m * n][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '#' || c == 'F') {
                    continue;
                }
                dfs(i * n + j, foodPos, CAT_TURN); // mouse win position
            }
        }

        return memo[mousePos][catPos][MOUSE_TURN] < 0;
    }

    private List<Integer>[] buildGraph(int jump, String[] grid) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        int m = grid.length, n = grid[0].length();

        List<Integer>[] graph = new List[m * n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                List<Integer> list = new ArrayList<Integer>();
                graph[i * n + j] = list;

                if (grid[i].charAt(j) == '#') {
                    continue;
                }
                list.add(i * n + j);

                for (int[] d : directions) {
                    for (int step = 1; step <= jump; step++) {
                        int x = i + d[0] * step, y = j + d[1] * step;

                        if (x < 0 || x >= m || y < 0 || y >= n || grid[x].charAt(y) == '#') {
                            break;
                        }
                        list.add(x * n + y);
                    }
                }
            }

        }
        return graph;
    }

    /**
     * p1: player 1, p2: player 2
     *
     * @param p1
     * @param p2
     * @param turn
     */
    private void dfs(int p1, int p2, int turn) {
        if (p1 == p2) {
            return;
        }

        if ((turn == MOUSE_TURN ? p2 : p1) == foodPos) {
            return;
        }

        if (memo[p1][p2][turn] < 0) {
            return;
        }
        memo[p1][p2][turn] = -1;

        turn ^= 1;
        for (int w : graphs[turn][p2]) {
            if (turn == MOUSE_TURN) {
                dfs(w, p1, turn);
            } else {
                ++memo[w][p1][turn];
                if (memo[w][p1][turn] == graphs[turn][w].size()) {
                    dfs(w, p1, turn);
                }
            }
        }

    }
}
