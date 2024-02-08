package com.yuren.leetcodecnlearn.Q2200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-02-08 23:34
 */
public class Q2224 {
    public int convertTime(String current, String correct) {
        int xc = (Integer.parseInt(correct.substring(0, 2)) - Integer.parseInt(current.substring(0, 2))) * 60
                 + Integer.parseInt(correct.substring(3, 5)) - Integer.parseInt(current.substring(3, 5));
        int sc = xc / 60;
        sc += (xc % 60) / 15;
        sc += ((xc % 60) % 15) / 5;
        sc += ((xc % 60) % 15) % 5;
        return sc;
    }
}
