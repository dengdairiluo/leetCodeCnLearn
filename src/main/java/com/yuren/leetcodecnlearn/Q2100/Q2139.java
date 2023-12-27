package com.yuren.leetcodecnlearn.Q2100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-27 23:31
 */
public class Q2139 {
    public int minMoves(int target, int maxDoubles) {
        int ans = 0;
        while (target > 1) {
            if (maxDoubles > 0) {
                if ((target & 1) == 0) {
                    target >>= 1;
                    ans += 1;
                    maxDoubles -= 1;
                } else if ((target & 1) == 1) {
                    target -= 1;
                    ans += 1;
                }
            } else {
                return ans + target - 1;
            }
        }
        return ans;
    }
}
