package com.yuren.leetcodecnlearn.Q800;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-08-06 23:48
 */
public class Q723 {
    public int[][] candyCrush(int[][] board) {
        int rows = board.length, cols = board[0].length;
        boolean todo = false;   // 是否存在要粉碎的糖果
        // 一行一行扫描
        for (int r = 0; r < rows; ++r) {
            for (int c = 0; c + 2 < cols; ++c) {
                // 取出这个点的绝对值（可能被取反了，所以要绝对值）
                int v = Math.abs(board[r][c]);
                // 如果连续三个格子是相同的糖果
                if (v != 0 && v == Math.abs(board[r][c + 1]) && v == Math.abs(board[r][c + 2])) {
                    // 把这三个连续格子的糖果数值取反，表明待粉碎状态
                    board[r][c] = board[r][c + 1] = board[r][c + 2] = -v;
                    todo = true;
                }
            }
        }
        // 一列一列扫描
        for (int r = 0; r + 2 < rows; ++r) {
            for (int c = 0; c < cols; ++c) {
                // 取出这个点的绝对值（可能被取反了，所以要绝对值）
                int v = Math.abs(board[r][c]);
                // 如果连续三个格子是相同的糖果
                if (v != 0 && v == Math.abs(board[r + 1][c]) && v == Math.abs(board[r + 2][c])) {
                    // 把这三个连续格子的糖果数值取反，表明待粉碎状态
                    board[r][c] = board[r + 1][c] = board[r + 2][c] = -v;
                    todo = true;
                }
            }
        }
        // 经过上面两个 for 循环后，需要粉碎糖果的格子已经变为负数

        // 遍历所有格子进行粉碎糖果
        if (todo) {
            for (int c = 0; c < cols; ++c) {   // 从左到右每一列
                int wr = rows - 1;  // 接收掉落糖果所在行
                for (int r = rows - 1; r >= 0; r--) {  // 从下往上遍历每一行
                    if (board[r][c] > 0) {
                        // 把 (r,c) 的糖果掉落到 (wr,c) 上
                        // r 和 wr 要么在同一行，要么 r 在上面，因此不用特地找到 wr 的初始行。
                        board[wr][c] = board[r][c];
                        wr--;   // 往上走一行
                    }
                }
                // 如果 wr 没有走到最顶行，说明上面应该全是要粉碎的
                while (wr >= 0) {
                    board[wr--][c] = 0;
                }
            }
        }
        // 如果还有需要粉碎的糖果，则再调用一次 candyCrush(board)
        // 注意，本次 candyCrush 后是不确定存不存在新的要粉碎的糖果，只能再调用一次 candyCrush
        // 如果多调用的 candyCrush 中两个 for 循环都没有把 tod0 标记为 true，则表示结束了
        // 因此，本方法都会多调用一次 candyCrush 但不进行粉碎的操作。
        return todo ? candyCrush(board) : board;
    }

}
