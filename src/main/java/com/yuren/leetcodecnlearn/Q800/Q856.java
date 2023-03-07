package com.yuren.leetcodecnlearn.Q800;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-07-13 22:57
 */
public class Q856 {
    public int scoreOfParentheses(String S) {
        return f(S, 0, S.length());
    }

    public int f(String s, int i, int j) {
        //Score of balanced string S[i:j]
        int ans = 0, bal = 0;

        // Split string into primitives
        for (int k = i; k < j; ++k) {
            bal += s.charAt(k) == '(' ? 1 : -1;
            if (bal == 0) {
                if (k - i == 1) ans++;
                else ans += 2 * f(s, i+1, k);
                i = k+1;
            }
        }

        return ans;
    }
}
