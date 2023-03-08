package com.yuren.leetcodecnlearn.Q1800;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-05-31 20:20
 */
public class Q1869 {
    public boolean checkZeroOnes(String s) {
        int l = s.length();
        int m = 0, resm = 0;
        int n = 0, resn = 0;
        for (int i = 0; i < l; i++) {
            if (s.charAt(i) == '1') {
                m++;
                resm = Math.max(m, resm);
                n = 0;
            } else {
                n++;
                m = 0;
                resn = Math.max(n, resn);
            }
        }
        return resm > resn;
    }
}
