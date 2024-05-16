package com.yuren.leetcodecnlearn.Q2400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-05-16 下午11:51
 */
public class Q2416 {
    public int[] sumPrefixScores(String[] words) {

        int P = 131;
        long[][] h = new long[words.length][1010];
        for (int i = 0; i < words.length; i++)
            for (int j = 1; j <= words[i].length(); j++)
                h[i][j] = h[i][j - 1] * P + words[i].charAt(j - 1);

        int ans[] = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            for (int j = i; j < words.length; j++) {
                int left = 0, right = Math.min(words[i].length(), words[j].length());
                while (left < right) {
                    int mid = left + right + 1 >> 1;
                    if (h[i][mid] == h[j][mid]) left = mid;
                    else right = mid - 1;
                }
                ans[i] += left;
                if (i != j) ans[j] += left;
            }
        }

        return ans;
    }
}
