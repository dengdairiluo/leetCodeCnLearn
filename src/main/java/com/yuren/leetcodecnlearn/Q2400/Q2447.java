package com.yuren.leetcodecnlearn.Q2400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-05-30 下午11:44
 */
public class Q2447 {
    public int subarrayGCD(int[] nums, int k) {
        int n = nums.length, l = 0, r = 0, f = nums[r], c = 0;
        while (r < n) {
            int e = gcd(f, nums[r]);
            if (e % k != 0) {
                r++;
                if (r == n) break;
                l = r;
                f = nums[r];
                continue;
            } else if (e == k) {
                int p = r, d = nums[r];
                while (p >= l) {
                    int g = gcd(nums[p], d);
                    if (g == k) {
                        c += p - l + 1;
                        break;
                    }
                    d = g;
                    p--;
                }
            }
            f = e;
            r++;
        }
        return c;
    }

    public int gcd(int a, int b) {
        if (a < b) return gcd(b, a);
        return a % b == 0 ? b : gcd(b, a % b);
    }
}
