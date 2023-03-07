package com.yuren.leetcodecnlearn.Q900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-08-24 23:45
 */
public class Q957 {
    public int[] prisonAfterNDays(int[] cells, int n) {
        //由于循环长度固定为14，那么可以直接计算出最终状态首次出现的天数p
        int p = (n - 1) % 14;
        //将cells转换成二进制数bin
        int bin = 0;
        int dig = 1;
        for (int i = 7; i >= 0; i--) {
            bin += cells[i] * dig;
            dig *= 2;
        }
        //直接计算出第p天的状态
        for (int i = 0; i <= p; i++) {
            bin = ~(bin << 1 ^ bin >> 1) & 0x7E;
        }
        //将最终状态转换回数组
        int i = 7;
        while (bin > 0) {
            cells[i--] = bin % 2;
            bin /= 2;
        }
        while (i >= 0) {
            cells[i--] = 0;
        }
        return cells;
    }
}
