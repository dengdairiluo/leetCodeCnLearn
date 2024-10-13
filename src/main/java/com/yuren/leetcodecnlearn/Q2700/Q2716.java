package com.yuren.leetcodecnlearn.Q2700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-10-14 03:01
 */
public class Q2716 {
    public int minimizedStringLength(String s) {
        int mask = 0;
        for (char c : s.toCharArray())
            mask |= 1 << (c - 'a');
        return Integer.bitCount(mask);
    }
}
