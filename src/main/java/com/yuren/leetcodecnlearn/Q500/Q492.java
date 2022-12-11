package com.yuren.leetcodecnlearn.Q500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-02-02 22:52
 */
public class Q492 {
    public int[] constructRectangle(int area) {
        int w = (int) Math.sqrt(area);
        while (area % w != 0) {
            --w;
        }
        return new int[]{area / w, w};
    }
}
