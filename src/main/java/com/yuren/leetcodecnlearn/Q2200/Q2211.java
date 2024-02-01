package com.yuren.leetcodecnlearn.Q2200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-02-01 23:19
 */
public class Q2211 {
    public int countCollisions(String directions) {
        int left = 0, right = directions.length() - 1;
        int ans = 0;
        while (left <= right && directions.charAt(left) == 'L') {
            left++;
        }
        while (left <= right && directions.charAt(right) == 'R') {
            right--;
        }
        for (int i = left; i <= right; i++) {
            if (directions.charAt(i) != 'S') {
                ans++;
            }
        }
        return ans;
    }
}
