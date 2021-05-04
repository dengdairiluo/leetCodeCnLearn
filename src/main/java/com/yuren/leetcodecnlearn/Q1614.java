package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-01-23 21:36
 */
public class Q1614 {

    public int maxDepth(String s) {
        int maxNm = -1;
        int curNm = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                curNm++;
            }
            if (c == ')') {
                curNm--;
            }
            maxNm = Math.max(maxNm, curNm);
        }
        return maxNm;
    }


}
