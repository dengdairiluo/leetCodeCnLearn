package com.yuren.leetcodecnlearn.Q2100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-01-02 23:10
 */
public class Q2151 {
    public int maximumGood(int[][] statements) {
        int n = statements.length;
        int[][] arr = new int[n][2]; // [0] ~ good told by i, [1] ~ bad told by i
        for (int i = 0; i < n; i++) {
            int good = 0;
            int bad = 0;
            for (int j = 0; j < n; j++) {
                if (statements[i][j] == 1) {
                    good = good | (1 << j);
                } else if (statements[i][j] == 0) {
                    bad = bad | (1 << j);
                }
            }
            arr[i] = new int[]{good, bad};
        }
        int res = 0;
        for (int mask = (1 << n) - 1; mask >= 0; mask--) {
            if (isValid(arr, mask)) {
                res = Math.max(res, Integer.bitCount(mask));
            }
        }
        return res;
    }

    private boolean isValid(int[][] arr, int mask) {
        for (int i = 0; i < arr.length; i++) {
            if ((mask & (1 << i)) == 0) {
                continue;
            }
            if ((arr[i][0] & mask) != arr[i][0]) {
                return false;
            }
            if ((arr[i][1] & mask) != 0) {
                return false;
            }
        }
        return true;
    }
}
