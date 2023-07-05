package com.yuren.leetcodecnlearn.Q1700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-07-05 23:38
 */
public class Q1745 {
    public boolean checkPartitioning(String s) {
        int length = s.length();
        //dp[i][j]：表示字符串s从下标i到j是否是回文串
        boolean[][] dp = new boolean[length][length];
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                //如果i和j指向的字符不一样，那么dp[i][j]就
                //不能构成回文字符串
                if (s.charAt(i) != s.charAt(j))
                    continue;
                dp[i][j] = j - i <= 2 || dp[i + 1][j - 1];
            }
        }

        //然后再截取3段，判断这3段是否都是回文的
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length - 1; j++) {
                if (dp[0][i] && dp[i + 1][j] && dp[j + 1][length - 1])
                    return true;
            }
        }
        return false;
    }

}
