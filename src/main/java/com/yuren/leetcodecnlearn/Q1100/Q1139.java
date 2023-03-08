package com.yuren.leetcodecnlearn.Q1100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-11-09 23:10
 */
public class Q1139 {
    public int largest1BorderedSquare(int[][] grid) {
        int maxLen = 0;
        if (grid.length == 0 && grid[0].length == 0) {
            return 0;
        }
        boolean flag1 = true, flag2 = true;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    flag1 = true;
                    int cur = maxLen;
                    while (i + cur < grid.length && j + cur < grid[0].length) {
                        flag2 = true;
                        for (int k = i; k < i + cur + 1; k++) {
                            if (grid[k][j] == 0) {
                                flag1 = false;
                                break;
                            }
                        }
                        if (!flag1) {
                            break;
                        }
                        for (int k = j; k < j + cur + 1; k++) {
                            if (grid[i][k] == 0) {
                                flag1 = false;
                                break;
                            }
                        }
                        if (!flag1) {
                            break;
                        }
                        for (int k = i; k < i + cur + 1; k++) {
                            if (grid[k][j + cur] == 0) {
                                flag2 = false;
                                cur++;
                                break;
                            }
                        }
                        if (!flag2) {
                            continue;
                        }
                        for (int k = j; k < j + cur + 1; k++) {
                            if (grid[i + cur][k] == 0) {
                                flag2 = false;
                                cur++;
                                break;
                            }
                        }
                        if (!flag2) {
                            continue;
                        }
                        cur++;
                        maxLen = cur;
                    }
                }
            }
        }
        return maxLen * maxLen;
    }
}
