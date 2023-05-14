package com.yuren.leetcodecnlearn.Q1600;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-05-15 00:00
 */
public class Q1604 {
    static long a[] = new long[100001];

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        List<String> res = new ArrayList<String>();
        int n = keyTime.length, i = 0, j = 0, m, x;
        if (n < 3) {
            return res;
        }
        long z, w;
        byte s[] = new byte[10];
        for (String k : keyTime) {
            x = 61;
            z = 0;
            m = k.charAt(0) * 600 + k.charAt(1) * 60 + k.charAt(3) * 10 + k.charAt(4) - 32208;
            for (byte b : keyName[i++].getBytes()) {
                x -= 5;
                w = b - 96;
                z += w << x;
            }
            a[j++] = z + m;
        }
        Arrays.sort(a, 0, n);
        for (z = w = j = 0, i = 1; ++i < n; ) {
            if (a[i] - a[i - 2] > 60 || (w ^ a[i]) < 2048) {
                continue;
            }
            z = w = a[i];
            z >>= 11;
            m = 10;
            while ((z & 31) == 0) {
                z >>= 5;
            }
            do {
                s[--m] = (byte) ((z & 31) + 96);
            } while ((z >>= 5) != 0);
            res.add(new String(s, m, 10 - m));
        }
        return res;
    }
}
