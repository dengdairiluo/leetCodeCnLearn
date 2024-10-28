package com.yuren.leetcodecnlearn.Q2700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-10-28 23:52
 */
public class Q2748 {
    public int countBeautifulPairs(int[] nums) {
        int ans = 0;
        int[] cnt = new int[10];
        for (int x : nums) {
            for (int y = 1; y < 10; y++) {
                if (cnt[y] > 0 && gcd(y, x % 10) == 1) {
                    ans += cnt[y];
                }
            }
            while (x >= 10) {
                x /= 10;
            }
            // 统计最高位的出现次数
            cnt[x]++;
        }
        return ans;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
