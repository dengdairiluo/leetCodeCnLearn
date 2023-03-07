package com.yuren.leetcodecnlearn.Q800;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-06-21 23:16
 */
public class Q806 {
    public static final int MAX_WIDTH = 100;

    public int[] numberOfLines(int[] widths, String s) {
        int lines = 1;
        int width = 0;
        for (int i = 0; i < s.length(); i++) {
            int need = widths[s.charAt(i) - 'a'];
            width += need;
            if (width > MAX_WIDTH) {
                lines++;
                width = need;
            }
        }
        return new int[]{lines, width};
    }
}
