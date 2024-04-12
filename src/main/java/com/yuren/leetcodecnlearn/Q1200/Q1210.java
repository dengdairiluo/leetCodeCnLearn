package com.yuren.leetcodecnlearn.Q1200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-12-11 22:37
 */
public class Q1210 {
    private static final int STATE_VER = 0, STATE_HOR = 1;
    public final int MAX_VALUE_OUT_OF_BOUND = 10000;
    public final int MOVE_RIGHT = 0, MOVE_DOWN = 1, MOVE_ROTATE_RIGHT = 2, MOVE_ROTATE_DOWN = 3;
    private final int[] DIR = {MOVE_RIGHT, MOVE_DOWN, MOVE_ROTATE_RIGHT, MOVE_ROTATE_DOWN};
    int result = MAX_VALUE_OUT_OF_BOUND;
    /**
     * 已经访问的节点（x,y,state,counts)
     */
    int[][][] visited;

    public int minimumMoves(int[][] grid) {
        int n = grid.length;
        visited = new int[n][n][2];
        getMinMove(grid, 0, 0, STATE_HOR, 0);
        return result == MAX_VALUE_OUT_OF_BOUND ? -1 : result;
    }

    /**
     * dps
     *
     * @param grid
     * @param x1
     * @param y1
     * @param state
     * @param minMove
     */
    public void getMinMove(int[][] grid, int x1, int y1, int state, int minMove) {
        int n = grid.length;
        if (n == 0) {
            return;
        }
        if (minMove > result) {
            return;
        }

        int x2 = x1, y2 = y1;
        if (state == STATE_HOR) {
            y2 = y1 + 1;
        } else {
            x2 = x1 + 1;
        }

        //达到终点
        if ((x2 == (n - 1)) && (y2 == (n - 1)) && (x1 == (n - 1)) && (y1 == (n - 2))) {
            result = Math.min(result, minMove);
            return;
        }
        //当前节点已经被访问，且从初始点至当前节点的步数大于历史步数，不再对当前节点往下遍历
        if ((visited[x1][y1][state] != 0) && (visited[x1][y1][state] <= minMove + 1)) {
            return;
        }
        //记录当前节点的步数
        visited[x1][y1][state] = minMove + 1;
        //遍历当前节点
        for (int j : DIR) {
            if (canMove(grid, x1, y1, state, j)) {
                switch (j) {
                    case MOVE_DOWN: {
                        getMinMove(grid, x1 + 1, y1, state, minMove + 1);
                        break;
                    }
                    case MOVE_RIGHT: {
                        getMinMove(grid, x1, y1 + 1, state, minMove + 1);
                        break;
                    }
                    case MOVE_ROTATE_RIGHT: {
                        getMinMove(grid, x1, y1, STATE_HOR, minMove + 1);
                        break;
                    }
                    case MOVE_ROTATE_DOWN: {
                        getMinMove(grid, x1, y1, STATE_VER, minMove + 1);
                        break;

                    }
                    default:
                        break;
                }
            }
        }
    }

    public boolean canMove(int[][] grid, int x1, int y1, int state, int dir) {
        int n = grid.length;
        int x2 = x1, y2 = y1;
        if (state == STATE_HOR) {
            y2 = y1 + 1;
        } else {
            x2 = x1 + 1;
        }

        boolean canMove = false;
        switch (dir) {
            case MOVE_DOWN: {
                if ((x1 + 1 < n) && (x2 + 1) < n && (grid[x1 + 1][y1] == 0) && (grid[x2 + 1][y2] == 0)) {
                    canMove = true;
                }
                break;
            }
            case MOVE_RIGHT: {
                if ((y1 + 1 < n) && (y2 + 1) < n && (grid[x1][y1 + 1] == 0) && (grid[x2][y2 + 1] == 0)) {
                    canMove = true;
                }
                break;
            }
            case MOVE_ROTATE_RIGHT: {
                if ((state == STATE_VER) && (y1 + 1 < n) && (grid[x1][y1 + 1] == 0) && (grid[x2][y2 + 1] == 0)) {
                    canMove = true;
                }
                break;
            }
            case MOVE_ROTATE_DOWN: {
                if ((state == STATE_HOR) && (x1 + 1 < n) && (grid[x1 + 1][y1] == 0) && (grid[x2 + 1][y2] == 0)) {
                    canMove = true;
                }
                break;

            }
            default:
                break;
        }
        return canMove;
    }
}
