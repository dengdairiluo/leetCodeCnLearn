package com.yuren.leetcodecnlearn.Q800;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-07-01 23:38
 */
public class Q828 {
    private static final char A = 'A';
    private int M = (int) 1e9 + 7;

    public int uniqueLetterString(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        int[][] dic = new int[26][2];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 2; j++) {
                // 结算dic[cur][1]位置，只包含dic[cur][1]位置字符的子串数量。初始为-1，便于判断是否出现和结算只出现1次的字符
                dic[i][j] = -1;
            }
        }
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int cur = chars[i] - A;
            // 第一次出现的字符给dic[cur][1];
            if (dic[cur][1] == -1) {
                dic[cur][1] = i;
            } else {
                // 子串只包含dic[cur][1]位置字符的数量
                int num = (dic[cur][1] - dic[cur][0]) * (i - dic[cur][1]);
                // 累和
                ans = (ans + num + M) % M;
                // 计算过的dic[cur][1]变成左边界
                dic[cur][0] = dic[cur][1];
                // 当前i变成下一个结算的位置
                dic[cur][1] = i;
            }
        }
        // 跳出第一个for没有被结算到的位置，用len结算
        for (int cur = 0; cur < 26; cur++) {
            if (dic[cur][1] != -1) {
                int num = (dic[cur][1] - dic[cur][0]) * (len - dic[cur][1]);
                ans = (ans + num + M) % M;
            }
        }
        return ans;
    }
}
