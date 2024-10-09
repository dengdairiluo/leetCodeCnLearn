package com.yuren.leetcodecnlearn.Q2700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-10-09 23:45
 */
public class Q2710 {
    public String removeTrailingZeros(String num) {
        return num.replaceAll("0+$", "");
    }
}
