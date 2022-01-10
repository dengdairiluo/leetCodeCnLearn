package com.yuren.leetcodecnlearn;

public class Q443 {
    public int compress(char[] chars) {
        int n = chars.length, write = 0;
        for (int i = 0; i < n; ) {
            int j = i;
            while (j < n && chars[i] == chars[j]) {
                j++;
            }
            chars[write++] = chars[i];
            if (j - i > 1) {
                String tmp = Integer.toString(j - i);
                for (int k = 0; k < tmp.length(); k++) {
                    chars[write++] = tmp.charAt(k);
                }
            }
            i = j;
        }
        return write;
    }
}
