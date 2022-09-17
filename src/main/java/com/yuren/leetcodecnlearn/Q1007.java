package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-09-17 23:55
 */
public class Q1007 {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int ans = 20000;
        for (int i = 1; i <= 6; i++) {
            int t = 0, b = 0, j = 0;
            while (j < bottoms.length && (tops[j] == i || bottoms[j] == i)) {
                if (tops[j] != i) {
                    t++;
                }
                if (bottoms[j] != i) {
                    b++;
                }
                j++;
            }
            if (j == bottoms.length)
                ans = Math.min(ans, Math.min(t, b));
        }
        return ans == 20000 ? -1 : ans;
    }
}
