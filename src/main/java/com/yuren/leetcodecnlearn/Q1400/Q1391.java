package com.yuren.leetcodecnlearn.Q1400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-02-20 23:42
 */
public class Q1391 {
    public boolean hasValidPath(int[][] grid) {
        if (grid[0][0] != 4) {
            return test(grid, 0);
        } else {
            if (test(grid, 1)) {
                return true;
            } else {
                return test(grid, 4);
            }
        }
    }

    public boolean test(int[][] grid, int dir) {
        int num = 0;
        int i = 0, j = 0;
        while (i != grid.length - 1 || j != grid[0].length - 1) {
            switch (grid[i][j]) {
                case 1:
                    if (dir == 4) {
                        j--;
                        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1) {
                            return false;
                        }
                        if (grid[i][j] == 2 || grid[i][j] == 3 || grid[i][j] == 5) {
                            return false;
                        }
                    } else {
                        j++;
                        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1) {
                            return false;
                        }
                        if (grid[i][j] == 2 || grid[i][j] == 4 || grid[i][j] == 6) {
                            return false;
                        }
                        dir = 2;
                    }
                    break;
                case 2:
                    if (dir == 1) {
                        i--;
                        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1) {
                            return false;
                        }
                        if (grid[i][j] == 1 || grid[i][j] == 5 || grid[i][j] == 6) {
                            return false;
                        }
                    } else {
                        i++;
                        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1) {
                            return false;
                        }
                        if (grid[i][j] == 1 || grid[i][j] == 3 || grid[i][j] == 4) {
                            return false;
                        }
                        dir = 3;
                    }
                    break;
                case 3:
                    if (dir == 1) {
                        j--;
                        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1) {
                            return false;
                        }
                        if (grid[i][j] == 1 || grid[i][j] == 5 || grid[i][j] == 6) {
                            return false;
                        }
                        dir = 4;
                    } else {
                        i++;
                        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1) {
                            return false;
                        }
                        if (grid[i][j] == 1 || grid[i][j] == 3 || grid[i][j] == 4) {
                            return false;
                        }
                        dir = 3;
                    }
                    break;
                case 4:
                    if (++num > 1 && i == 0 && j == 0) {
                        return false;
                    }
                    if (dir == 1) {
                        j++;
                        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1) {
                            return false;
                        }
                        if (grid[i][j] == 2 || grid[i][j] == 4 || grid[i][j] == 6) {
                            return false;
                        }
                        dir = 2;
                    } else {
                        i++;
                        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1) {
                            return false;
                        }
                        if (grid[i][j] == 1 || grid[i][j] == 3 || grid[i][j] == 4) {
                            return false;
                        }
                        dir = 3;
                    }
                    break;
                case 5:
                    if (dir == 2) {
                        i--;
                        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1) {
                            return false;
                        }
                        if (grid[i][j] == 1 || grid[i][j] == 5 || grid[i][j] == 6) {
                            return false;
                        }
                        dir = 1;
                    } else {
                        j--;
                        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1) {
                            return false;
                        }
                        if (grid[i][j] == 2 || grid[i][j] == 3 || grid[i][j] == 5) {
                            return false;
                        }
                        dir = 4;
                    }
                    break;
                case 6:
                    if (dir == 4) {
                        i--;
                        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1) {
                            return false;
                        }
                        if (grid[i][j] == 1 || grid[i][j] == 5 || grid[i][j] == 6) {
                            return false;
                        }
                        dir = 1;
                    } else {
                        j++;
                        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1) {
                            return false;
                        }
                        if (grid[i][j] == 2 || grid[i][j] == 4 || grid[i][j] == 6) {
                            return false;
                        }
                        dir = 2;
                    }
                    break;
            }
        }
        return true;
    }
}
