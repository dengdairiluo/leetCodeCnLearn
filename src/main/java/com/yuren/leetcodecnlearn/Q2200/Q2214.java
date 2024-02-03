package com.yuren.leetcodecnlearn.Q2200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-02-03 23:09
 */
public class Q2214 {
    public long minimumHealth(int[] damage, int armor) {
        long result = 0;
        int md = 0;
        for (int d : damage) {
            result += d;
            md = Math.max(md, d);
        }
        return result + 1 - Math.min(armor, md);
    }
}
