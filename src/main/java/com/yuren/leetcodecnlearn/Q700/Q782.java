package com.yuren.leetcodecnlearn.Q700;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-06-10 23:18
 */
public class Q782 {
    public int movesToChessboard(int[][] board) {
        //zero表示0开头的行，one表示0开头的列，row[i]表示每一行开头的值
        int[] zero = null, one = null, row = new int[board.length];
        //分别表示以0，1开头的行的数量
        int cntZero = 0, cntOne = 0;
        //最小移动数
        int moves = 0;
        for (int i = 0; i < board.length; i++) {
            //记下当前行开头的值
            row[i] = board[i][0];
            //如果以0开头
            if (board[i][0] == 0) {
                //数量加1
                cntZero++;
                //如果以0开头的行未赋值那么赋值
                if (zero == null) {
                    zero = board[i];
                } else if (!Arrays.equals(zero, board[i])) {
                    //如果已赋值但是与原来的行不同，那么不可能完成，返回-1
                    return -1;
                }
            } else {
                cntOne++;
                if (one == null) {
                    one = board[i];
                } else if (!Arrays.equals(one, board[i])) {
                    return -1;
                }
            }
        }
        //如果以0，1开头的行的数量差超过1，那么不可能完成
        if (Math.abs(cntOne - cntZero) > 1) {
            return -1;
        }
        //如果以0，1开头的行对应列的值相同，那么不可能完成
        for (int i = 0; i < board[0].length; i++) {
            if (one[i] == zero[i]) {
                return -1;
            }
        }
        //统计将行交换符合条件的最小移动数量
        moves += move(row, -1, cntOne, cntZero);
        //统计列中0，1开头的数量
        cntOne = 0;
        cntZero = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[0][i] == 0) {
                cntZero++;
            } else {
                cntOne++;
            }
        }
        //如果以0，1开头的列的数量差超过1，那么不可能完成
        if (Math.abs(cntOne - cntZero) > 1) {
            return -1;
        }
        //统计将列交换符合条件的最小移动数量
        moves += move(board[0], -1, cntOne, cntZero);
        return moves;
    }

    int move(int[] row, int flag, int cntOne, int cntZero) {
        //flag为-1说明未确定当前哪个数量要放前面
        if (flag == -1) {
            //数量大的肯定要放前面
            if (cntOne > cntZero) {
                return move(row, 1, cntOne, cntZero);
            } else if (cntOne < cntZero) {
                return move(row, 0, cntOne, cntZero);
            } else {
                //如果数量相同，那么取两者最小值
                return Math.min(move(Arrays.copyOf(row, row.length), 0, cntOne, cntZero),
                        move(Arrays.copyOf(row, row.length), 1, cntOne, cntZero));
            }
        }
        int moves = 0;
        for (int i = 0; i < row.length; i++) {
            //如果当前位置的值不符合要求
            if ((i % 2 == 0 && row[i] != flag) || (i % 2 != 0 && row[i] == flag)) {
                //移动数量加1
                moves++;
                //在当前位置之后查找下一个值不符合要求并且与前面位置值不同的的位置
                for (int j = i + 1; j < row.length; j++) {
                    if (((j % 2 != 0 && row[j] == flag) || (j % 2 == 0 && row[j] != flag)) && row[i] != row[j]) {
                        row[i] ^= row[j];
                        row[j] ^= row[i];
                        row[i] ^= row[j];
                        break;
                    }
                }
            }
        }
        return moves;
    }
}
