package com.yuren.leetcodecnlearn.Q1700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-07-11 22:28
 */
public class Q1759 {
    public int countHomogenous(String s) {
        long sum = 1;
        int M = (int) 1e9 + 7;
        int n = s.length();
        char[] c = s.toCharArray();
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (c[i - 1] == c[i]) count++;
            else count = 1;
            sum += count;
        }
        return (int) (sum % M);
    }
}
