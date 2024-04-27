package com.yuren.leetcodecnlearn.Q2300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-04-27 下午10:16
 */
public class Q2380 {
    public int secondsToRemoveOccurrences(String s) {
        int f = 0, pre0 = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                pre0++;
            } else if (pre0 > 0) {
                f = Math.max(f + 1, pre0);
            }
        }
        return f;
    }
}
