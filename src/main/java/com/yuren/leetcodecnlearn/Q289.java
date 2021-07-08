package com.yuren.leetcodecnlearn;

public class Q289 {
    public void gameOfLife(int[][] board) {
        // 我们将外围再围上一圈
        // 并将新增的这一圈全部赋值为0
        // 避免边界的数组越界问题
        int[][] temp = new int[board.length + 2][board[0].length + 2];
        for (int i = 0; i < temp.length; i++) {
            if (i >= 1 && i < temp.length - 1) {
                for (int j = 1; j < temp[i].length - 1; j++) {
                    temp[i][j] = board[i - 1][j - 1];
                }
            } else {
                for (int j = 0; j < temp[i].length; j++) {
                    temp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < temp.length - 1; i++) {
            for (int j = 1; j < temp[i].length - 1; j++) {
                int aliveCellNumber = 0;
                if (temp[i - 1][j - 1] == 1) {
                    aliveCellNumber++;
                }
                if (temp[i - 1][j] == 1) {
                    aliveCellNumber++;
                }
                if (temp[i - 1][j + 1] == 1) {
                    aliveCellNumber++;
                }
                if (temp[i][j - 1] == 1) {
                    aliveCellNumber++;
                }
                if (temp[i][j + 1] == 1) {
                    aliveCellNumber++;
                }
                if (temp[i + 1][j - 1] == 1) {
                    aliveCellNumber++;
                }
                if (temp[i + 1][j] == 1) {
                    aliveCellNumber++;
                }
                if (temp[i + 1][j + 1] == 1) {
                    aliveCellNumber++;
                }

                if (temp[i][j] == 1) {
                    // 规则1和规则3
                    if (aliveCellNumber < 2 || aliveCellNumber > 3) {
                        board[i - 1][j - 1] = 0;
                    }
                } else {
                    // 规则4
                    if (aliveCellNumber == 3) {
                        board[i - 1][j - 1] = 1;
                    }
                }
            }
        }
    }
}
