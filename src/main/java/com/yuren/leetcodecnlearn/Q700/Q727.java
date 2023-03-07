package com.yuren.leetcodecnlearn.Q700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-05-17 23:40
 */
public class Q727 {
    public String minWindow(String s, String t) {
        int sPtr = 0, tPtr = 0;
        int sLen = s.length(), tLen = t.length();
        int minLen = Integer.MAX_VALUE;
        String res = "";
        while (sPtr < sLen) {
            if (s.charAt(sPtr) == t.charAt(tPtr)) tPtr++;
            // 匹配到所有t的字符的右边界
            if (tPtr == tLen) {
                // 记录此时sPtr的位置，即右边界位置
                int R = sPtr;
                // 逆向匹配到s的左边界
                while (tPtr > 0) {
                    if (s.charAt(sPtr) == t.charAt(tPtr - 1)) tPtr--;
                    sPtr--;
                }
                // 由于sPtr会减到第一个字符的前一个位置，此处应加1使下标到第一个字符
                sPtr++;
                // [sPtr,R] -> len = R-sPtr+1
                if (R - sPtr + 1 < minLen) {
                    minLen = R - sPtr + 1;
                    res = s.substring(sPtr, R + 1);
                }
            }
            sPtr++;
        }
        return res;
    }
}
