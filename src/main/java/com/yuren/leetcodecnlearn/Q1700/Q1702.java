package com.yuren.leetcodecnlearn.Q1700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-06-18 23:08
 */
public class Q1702 {
    public String maximumBinaryString(String binary) {
        byte[] bytes = binary.getBytes();

        int l = 0;
        while (l < bytes.length && bytes[l] != '0') {
            l++;
        }

        int r = l + 1;
        while (r < bytes.length) {
            while (r < bytes.length && bytes[r] != '0') {
                r++;
            }
            if (r < bytes.length) {
                bytes[l] = '1';
                bytes[r++] = '1';
                bytes[++l] = '0';
            }
        }
        return new String(bytes);
    }
}
