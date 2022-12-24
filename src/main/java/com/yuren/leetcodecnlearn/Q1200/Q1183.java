package com.yuren.leetcodecnlearn.Q1200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-11-29 23:57
 */
public class Q1183 {
    public int maximumNumberOfOnes(int width, int height, int sideLength, int maxOnes) {
        int wres = width % sideLength;
        int hres = height % sideLength;
        int ab = (wres) * sideLength;
        int ac = hres * sideLength;
        int a = wres * hres;
        int b = ab - a;
        int c = ac - a;
        int total = 0;
        int row = height / sideLength;
        int col = width / sideLength;
        total += col * row * maxOnes;
        if (maxOnes >= a) {
            maxOnes -= a;
            total += a * (row + col + 1);
        } else {
            total += maxOnes * (row + col + 1);
            return total;
        }

        if (row < col) {
            int temp = c;
            int tmp = col;
            c = b;
            col = row;
            b = temp;
            row = tmp;
        }
        if (maxOnes >= b) {
            maxOnes -= b;
            total += b * row;
        } else {
            total += maxOnes * row;
            return total;
        }

        if (maxOnes >= c) {
            total += c * col;
        } else {
            total += maxOnes * col;
        }
        return total;

    }
}
