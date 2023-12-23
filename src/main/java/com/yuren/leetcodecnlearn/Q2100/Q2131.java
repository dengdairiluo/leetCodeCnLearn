package com.yuren.leetcodecnlearn.Q2100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-23 22:43
 */
public class Q2131 {
    public int longestPalindrome(String[] words) {
        int[][] arr = new int[26][26];    // arr[0][1] = 1; 表示 ab 有一个

        // 初始化 二维数组
        for (String word : words) {
            arr[word.charAt(0) - 'a'][word.charAt(1) - 'a']++;
        }

        int concatStrCount = 0;    // 连接的字符串数目
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (arr[i][j] == 0 || arr[j][i] == 0) continue;

                if (i == j) {    // 字符串本身就 回文
                    if (arr[i][j] % 2 == 0) {
                        concatStrCount += arr[i][j];    // 放两边
                        arr[i][j] = 0;
                    } else {
                        concatStrCount += concatStrCount % 2 == 0 ? arr[i][j] : arr[i][j] - 1;    // 奇数个 类似aa字符串，插入 中间或两边
                        arr[i][j] = arr[i][j] % 2;
                    }
                } else {
                    int minCount = Math.min(arr[i][j], arr[j][i]);
                    concatStrCount += minCount * 2;
                    arr[i][j] -= minCount;
                    arr[j][i] -= minCount;
                }
            }
        }

        return concatStrCount * 2;
    }
}
