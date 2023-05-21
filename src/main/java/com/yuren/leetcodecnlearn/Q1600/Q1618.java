package com.yuren.leetcodecnlearn.Q1600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-05-21 22:59
 */
public class Q1618 {
    public int maxFont(String text, int w, int h, int[] fonts, FontInfo fontInfo) {
        int l = 0, r = fonts.length - 1;
        char[] ss = text.toCharArray();
        for (; l < r - 1; ) {
            int m = (l + r) >> 1;
            if (isValid(ss, w, h, fontInfo, fonts[m])) {
                l = m;
            } else {
                r = m;
            }
        }
        return isValid(ss, w, h, fontInfo, fonts[r]) ? fonts[r] : isValid(ss, w, h, fontInfo, fonts[l]) ? fonts[l] : -1;
    }

    private boolean isValid(char[] text, int w, int h, FontInfo fontInfo, int cur) {
        int curW = 0;
        int curH = fontInfo.getHeight(cur);
        for (char ch : text) {
            curW += fontInfo.getWidth(cur, ch);
        }

        return curW <= w && curH <= h;
    }

    private static class FontInfo {
        // Return the width of char ch when fontSize is used.
        public int getWidth(int fontSize, char ch) {
            return 0;
        }

        // Return Height of any char when fontSize is used.
        public int getHeight(int fontSize) {
            return 0;
        }
    }
}
