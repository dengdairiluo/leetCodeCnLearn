package com.yuren.leetcodecnlearn.Q2100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-31 19:20
 */
public class Q2147 {
    static int mod = (int) 1e9 + 7;

    public int numberOfWays(String corridor) {

        int n = corridor.length();
        byte[] bytes = new byte[n];
        corridor.getBytes(0, n, bytes, 0);
        int seats = 0;
        long result = 1;

        for (int i = 0; i < n; i++) {
            if (bytes[i] == 'S') {
                seats++;

                while (true) {
                    if (++i >= n || bytes[i] == 'S') break;

                }
                if (i < n && bytes[i] == 'S')
                    seats++;

                int divisions = 1;
                while (++i < n && bytes[i] != 'S')
                    divisions++;

                if (i < n && divisions > 1)
                    result = (result * divisions) % mod;

                i--;
            }
        }
        return (seats != 0 && seats % 2 == 0) ? (int) result : 0;
    }
}
