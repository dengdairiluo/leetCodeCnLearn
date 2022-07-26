package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-07-26 20:42
 */
public class Q885 {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] ans = new int[rows * cols][2];
        int total = rows * cols;
        int step = 1;
        int curstep = step;
        int go = 1;
        int count = 0;
        int i = rStart;
        int j = cStart;
        ans[count][0] = i;
        ans[count][1] = j;
        count++;
        while (count < total) {
            switch (go) {
                case 1:  // 一直向右
                    if (curstep > 0) {
                        curstep--;
                        j++;
                        if (i >= 0 && i < rows && j >= 0 && j < cols) {
                            ans[count][0] = i;
                            ans[count][1] = j;
                            count++;
                        }
                    }
                    if (curstep == 0) {
                        curstep = step;
                        go = 2;
                    }
                    break;
                case 2:  // 一直向下
                    if (curstep > 0) {
                        curstep--;
                        i++;
                        if (i >= 0 && i < rows && j >= 0 && j < cols) {
                            ans[count][0] = i;
                            ans[count][1] = j;
                            count++;
                        }
                    }
                    if (curstep == 0) {
                        step++;
                        curstep = step;
                        go = 3;
                    }
                    break;
                case 3:  // 一直向左
                    if (curstep > 0) {
                        curstep--;
                        j--;
                        if (i >= 0 && i < rows && j >= 0 && j < cols) {
                            ans[count][0] = i;
                            ans[count][1] = j;
                            count++;
                        }
                    }
                    if (curstep == 0) {
                        curstep = step;
                        go = 4;
                    }
                    break;
                case 4:  // 一直向上
                    if (curstep > 0) {
                        curstep--;
                        i--;
                        if (i >= 0 && i < rows && j >= 0 && j < cols) {
                            ans[count][0] = i;
                            ans[count][1] = j;
                            count++;
                        }
                    }
                    if (curstep == 0) {
                        step++;
                        curstep = step;
                        go = 1;
                    }
                    break;
                default:
                    break;
            }
        }
        return ans;
    }
}
