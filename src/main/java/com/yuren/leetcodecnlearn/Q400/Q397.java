package com.yuren.leetcodecnlearn.Q400;

public class Q397 {
    public int integerReplacement(int n) {
        long l = n;
        int ans = 0;
        while (l != 1) {
            if (l % 2 == 0) {
                l >>= 1;
            } else {
                if (l != 3 && ((l >> 1) & 1) == 1) l++;
                else l--;
            }
            ans++;
        }
        return ans;
    }
}
