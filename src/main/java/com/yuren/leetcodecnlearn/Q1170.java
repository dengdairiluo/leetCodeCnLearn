package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-11-24 23:52
 */
public class Q1170 {
    public int[] numSmallerByFrequency(String[] queries,
                                       String[] words) {
        int[] count = new int[12];
        for (String word : words) {
            count[get(word)]++;
        }
        for (int i = 9; i >= 0; i--) {
            count[i] += count[i + 1];
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = count[get(queries[i]) + 1];
        }
        return ans;
    }

    private int get(String word) {
        char max = 'z';
        int sum = 0;
        for (char c : word.toCharArray()) {
            if (c < max) {
                max = c;
                sum = 1;
            } else if (c == max) {
                sum++;
            }
        }
        return sum;
    }
}
