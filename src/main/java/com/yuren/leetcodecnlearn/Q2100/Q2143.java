package com.yuren.leetcodecnlearn.Q2100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-29 23:24
 */
public class Q2143 {
    public int countSubranges(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int s1 = 0, s2 = 0;
        int mod = (int) (1e9 + 7);

        for (int i = 0; i < n; i++) {
            s1 += nums1[i];
            s2 += nums2[i];
        }
        int base = Math.max(s1, s2);
        //初始化，这里使用 += 1是应为num1[i] == nums[2] == 0的情况
        int[][] f = new int[n][2 * base + 1];
        f[0][base + nums1[0]] += 1;
        f[0][base - nums2[0]] += 1;

        int ans = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= 2 * base; j++) {
                //f的每一个状态都需要初始化 同样使用 += 1 初始化
                if (nums1[i] + base == j) {
                    f[i][j] += 1;
                }
                if (-nums2[i] + base == j) {
                    f[i][j] += 1;
                }
                if (j - nums1[i] >= 0) {
                    f[i][j] = (f[i][j] % mod + f[i - 1][j - nums1[i]] % mod) % mod;
                }
                if (j + nums2[i] <= 2 * base) {
                    f[i][j] = (f[i][j] % mod + f[i - 1][j + nums2[i]] % mod) % mod;
                }

            }
        }
        // System.out.println(Arrays.deepToString(f));
        for (int i = 0; i < n; i++) {
            ans = (ans % mod + f[i][base] % mod) % mod;
        }
        return ans;
    }
}
