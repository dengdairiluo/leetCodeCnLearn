package com.yuren.leetcodecnlearn.Q1000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-08-31 23:46
 */
public class Q972 {
    public boolean isRationalEqual(String s, String t) {
        return Math.abs(parse(s) - parse(t)) < 1e-12;
    }

    static double parse(String s) {
        int n = s.length(), i = s.indexOf('(');
        if (i == -1) {
            return Double.parseDouble(s);
        }
        // 以 0.12(3456) 为例
        // 循环节之前值 0.12
        return Double.parseDouble(s.substring(0, i)) +
                // 循环节的值为 0.00(3456)
                // 先计算 0.(3456) = 3456/9999
                // 那么   0.00(3456) = 0.(3456)/100 = 3456/9999/100
                Integer.parseInt(s.substring(i + 1, n - 1)) / (Math.pow(10, n - i - 2) - 1) / Math.pow(10, i - s.indexOf('.') - 1);
    }
}
