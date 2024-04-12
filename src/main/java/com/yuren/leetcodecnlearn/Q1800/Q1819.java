package com.yuren.leetcodecnlearn.Q1800;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-08-06 21:32
 */
public class Q1819 {
    private static int gcd(int x, int y) {
        while (x != 0) {
            int tmp = x;
            x = y % x;
            y = tmp;
        }
        return y;
    }

    public int countDifferentSubsequenceGCDs(int[] nums) {
        int max = 0;
        int ans = 0;
        for (int num : nums)
            max = Math.max(max, num);
        boolean[] has = new boolean[max + 1];
        for (int num : nums) {
            if (!has[num]) {
                has[num] = true;
                ans++;
            }
        }
        for (int i = 1; i <= max / 3; i++) {
            if (has[i])
                continue;
            int g = 0;
            for (int j = i * 2; j <= max && g != i; j += i) {
                if (has[j])
                    g = gcd(g, j);
            }
            if (g == i)
                ans++;
        }
        return ans;
    }
}
