package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-04-03 19:51
 */
public class J17 {

    int[] res;
    int count = 0;

    public int[] printNumbers(int n) {
        res = new int[(int) Math.pow(10, n) - 1];
        for (int digit = 1; digit < n + 1; digit++) {
            for (char first = '1'; first <= '9'; first++) {
                char[] num = new char[digit];
                num[0] = first;
                dfs(1, num, digit);
            }
        }
        return res;
    }

    private void dfs(int index, char[] num, int digit) {
        if (index == digit) {
            res[count++] = Integer.parseInt(String.valueOf(num));
            return;
        }
        for (char i = '0'; i <= '9'; i++) {
            num[index] = i;
            dfs(index + 1, num, digit);
        }
    }

}
