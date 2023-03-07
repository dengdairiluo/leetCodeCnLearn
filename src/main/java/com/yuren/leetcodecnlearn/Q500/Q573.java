package com.yuren.leetcodecnlearn.Q500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-03-12 23:48
 */
public class Q573 {
    public int getDistance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int ans = (int) 1e9;
        int sumDis = 0;
        for (int[] nut : nuts) {
            sumDis += getDistance(nut, tree) * 2;
        }
        for (int[] firstNut : nuts) {
            int cur = sumDis - getDistance(firstNut, tree) + getDistance(firstNut, squirrel);
            ans = Math.min(cur, ans);
        }
        return ans;
    }
}
