package com.yuren.leetcodecnlearn.Q1300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-06 00:02
 */
public class Q1256 {
    public String encode(int num) {
        return Integer.toBinaryString(num + 1).substring(1);
    }
}
