package com.yuren.leetcodecnlearn.Q200;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-11-14 21:54
 */
public class Q294 {
    public boolean canWin(String s) {
        List<Integer> gList = new ArrayList<>();
        int n = s.length();
        int i = 0, j = 0;
        int max = 0;
        while (i < n) {
            if (s.charAt(i) == '-') {
                i++;
            } else {
                for (j = i; j < n && s.charAt(j) == '+'; j++) {

                }
                gList.add(j - i);
                if (j - i > max) {
                    max = j - i;
                }
                i = j + 1;
            }
        }
        if (max <= 1) {
            return false;
        }
        int[] g = new int[max + 1];
        g[0] = 0;
        g[1] = 0;
        for (int k = 2; k < max + 1; k++) {
            BitMap bm = new BitMap();
            for (int l = 0; l <= (k - 2) / 2; l++) {
                bm.set(g[l] ^ g[k - 2 - l]);
            }
            for (int l = 0; l < k; l++) {
                if (!bm.contains(l)) {
                    g[k] = l;
                    break;
                }
            }
        }
        int result = 0;
        while (!gList.isEmpty()) {
            result = result ^ g[gList.get(0)];
            gList.remove(0);
        }
        return result != 0;
    }

    private static class BitMap {
        char[] m;
        int n;

        BitMap(int n) {
            this.n = (n + 8) / 8;
            m = new char[this.n];
        }

        BitMap() {
            n = 1;
            m = new char[n];
        }

        private void expand(int k) {
            if ((k + 8) / 8 < n) {
                return;
            }
            int oldN = n;
            n = (k + 8) / 8 * 2;
            char[] newM = new char[n];
            if (oldN >= 0) {
                System.arraycopy(m, 0, newM, 0, oldN);
            }
            m = newM;
        }

        public boolean contains(int k) {
            expand(k);
            return (m[k >> 3] & (0x80 >> (k & 0x07))) != 0;
        }

        public void set(int k) {
            expand(k);
            m[k >> 3] = (char) (m[k >> 3] | (0x80 >> (k & 0x07)));
        }

        public void delete(int k) {
            expand(k);
            m[k >> 3] = (char) (m[k >> 3] & (~(0x80 >> (k & 0x07))));
        }
    }
}
