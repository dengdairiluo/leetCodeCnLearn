package com.yuren.leetcodecnlearn.Q1000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-09-17 23:56
 */
public class Q1009 {
    public int bitwiseComplement(int n) {
        int highbit = 0;
        for (int i = 1; i <= 30; ++i) {
            if (n >= 1 << i) {
                highbit = i;
            } else {
                break;
            }
        }
        int mask = highbit == 30 ? 0x7fffffff : (1 << (highbit + 1)) - 1;
        return n ^ mask;
    }
}
