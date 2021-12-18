package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-10-01 23:04
 */
public class Q157 {
    /**
     * api
     *
     * @param buf4
     * @return
     */
    private static int read4(char[] buf4) {
        return -1;
    }

    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int idx = 0;
        char[] buf4 = new char[4];
        int size = read4(buf4);
        while (size > 0 && idx < n) {
            for (int i = 0; i < size && idx < n; ++i) buf[idx++] = buf4[i];
            size = read4(buf4);
        }
        return idx;
    }
}
