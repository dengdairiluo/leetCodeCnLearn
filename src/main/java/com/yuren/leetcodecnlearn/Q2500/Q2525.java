package com.yuren.leetcodecnlearn.Q2500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-07-08 下午11:12
 */
public class Q2525 {
    public String categorizeBox(int length, int width, int height, int mass) {
        long v = (long) length * width * height;
        int bulky = length >= 10000 || width >= 10000 || height >= 10000 || v >= 1000000000 ? 1 : 0;
        int heavy = mass >= 100 ? 1 : 0;
        String[] d = {"Neither", "Bulky", "Heavy", "Both"};
        int i = heavy << 1 | bulky;
        return d[i];
    }
}
