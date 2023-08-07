package com.yuren.leetcodecnlearn.Q1800;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-08-07 23:32
 */
public class Q1830 {
    int MOD = (int) 1e9 + 7;

    public int makeStringSorted(String s) {
        int n = s.length();
        //每个字符的计数
        int[] charCnt = new int[26];
        //nF(i) = i!%MOD
        long[] nF = new long[n + 1];
        //nF1(i) 是 i!的逆元, 即(i!)^{MOD-2}%MOD
        long[] nF1 = new long[n + 1];
        for (int i = 0; i < n; i++) {
            int pos = s.charAt(i) - 'a';
            charCnt[pos]++;
        }
        nF[0] = 1;
        nF1[0] = 1;
        for (int i = 1; i <= n; i++) {
            nF[i] = (nF[i - 1] * i) % MOD;
            nF1[i] = pow(nF[i], MOD - 2);
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            int pos = s.charAt(i) - 'a';
            int smallThanPosCnt = 0;
            for (int j = 0; j < pos; j++) smallThanPosCnt += charCnt[j];
            long curRes = (nF[n - i - 1] * smallThanPosCnt) % MOD;
            for (int j = 0; j < 26; j++) {
                if (charCnt[j] > 1) curRes = (curRes * nF1[charCnt[j]]) % MOD;
            }
            res = (res + curRes) % MOD;
            charCnt[pos]--;
        }
        return (int) res;
    }

    //计算a^b%MOD
    private long pow(long a, int b) {
        long res = 1;
        long a1 = a;
        while (b > 0) {
            if ((b & 1) > 0) res = (res * a1) % MOD;
            a1 = (a1 * a1) % MOD;
            b = b / 2;
        }
        return res;
    }
}
