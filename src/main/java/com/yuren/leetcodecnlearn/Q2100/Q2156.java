package com.yuren.leetcodecnlearn.Q2100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-01-05 23:47
 */
public class Q2156 {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {

        char[] cs = s.toCharArray();
        int n = cs.length;

        long sum = 0, base = 1;
        for (int i = n - k; i < n; i++) {
            sum += (cs[i] - 'a' + 1) * base;
            sum %= modulo;
            base = base * power % modulo;
        }

        int l = n - k - 1;
        int ans = n - k;
        while (l >= 0) {
            sum *= power;
            sum -= (cs[l + k] - 'a' + 1) * base % modulo;
            sum += (cs[l] - 'a' + 1) % modulo;
            sum = (sum + modulo) % modulo;
            if (sum == hashValue)
                ans = l;
            l--;
        }
        return new String(cs, ans, k);
    }
}
