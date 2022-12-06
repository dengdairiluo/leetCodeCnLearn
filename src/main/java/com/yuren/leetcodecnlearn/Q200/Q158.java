package com.yuren.leetcodecnlearn.Q200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-10-01 23:07
 */
public class Q158 {
    int size = 0;
    int i = 0;
    char[] temp = new char[4];

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
        int index = 0;

        while (index < n) {
            if (size == 0) {
                size = read4(temp);
                if (size == 0)
                    break;
            }

            while (index < n && i < size) {
                buf[index++] = temp[i++];
            }

            if (i == size) {
                // 说明临时字符数组中的内容已经读完，size置零以便执行下一次read4操作
                i = 0;
                size = 0;
            }
        }

        return index;
    }
}
