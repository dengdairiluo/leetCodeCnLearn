package com.yuren.leetcodecnlearn.Q900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-06-27 23:14
 */
public class Q822 {
    public int flipGame(int[] fronts, int[] backs) {
        boolean[] hash = new boolean[2001];
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) {
                hash[fronts[i]] = true;
            }
        }
        int ans = 2002;
        for (int i = 0; i < fronts.length; i++) {
            if (!hash[fronts[i]]) {
                ans = Math.min(ans, fronts[i]);
            }
            if (!hash[backs[i]]) {
                ans = Math.min(ans, backs[i]);
            }
        }
        return ans == 2002 ? 0 : ans;
    }
}
