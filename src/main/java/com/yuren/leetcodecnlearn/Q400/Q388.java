package com.yuren.leetcodecnlearn.Q400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-12-19 23:25
 */
public class Q388 {
    public int lengthLongestPath(String input) {
        int max = 0, res = 0, k = 0, mark = 0;
        int[] v = new int[25];
        v[0] = -1;
        for (char ch : input.toCharArray()) {
            if (ch == '\n') {
                v[k + 1] = res + 1 + v[k];
                if (mark > 0)
                    max = Math.max(max, v[k + 1]);
                res = 0;
                k = 0;
                mark = 0;
            } else if (ch == '\t')
                k++;
            else {
                if (ch == '.') mark = 1;
                res++;
            }
        }
        if (mark > 0) max = Math.max(max, res + 1 + v[k]);
        return max;
    }
}
