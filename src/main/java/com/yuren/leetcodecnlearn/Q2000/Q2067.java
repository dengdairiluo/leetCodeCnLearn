package com.yuren.leetcodecnlearn.Q2000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-11-21 23:20
 */
public class Q2067 {
    int[][] arr;
    int n;

    public int equalCountSubstrings(String s, int count) {
        n = s.length();
        arr = new int[n + 1][26];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 26; j++) {
                arr[i][j] = arr[i - 1][j];
            }
            arr[i][s.charAt(i - 1) - 'a']++;
            for (int k = 1; k <= 26; k++) {
                if (i - count * k < 0) {
                    break;
                } else {
                    ans += verify(i, i - count * k, count);
                }
            }
        }
        return ans;
    }

    int verify(int endIdx, int startIdx, int count) {
        for (int i = 0; i < 26; i++) {
            int tmp = arr[endIdx][i] - arr[startIdx][i];
            if (tmp != count && tmp != 0) {
                return 0;
            }
        }
        return 1;
    }
}
