package com.yuren.leetcodecnlearn.Q1800;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-08-16 23:40
 */
public class Q1856 {
    public int maxSumMinProduct(int[] nums) {

        int n = nums.length;
        long mod = (int) 1e9 + 7L;
        long[] pres = new long[n + 1];
        int i = 0;
        for (; i < n; ++i) pres[i + 1] = pres[i] + nums[i];

        long res = 0, t = 0;
        int[] stack = new int[n + 1];
        int p = -1, index = 0;
        stack[++p] = -1;
        for (i = 0; i <= n; ++i) {

            while (stack[p] != -1 && (i == n || nums[stack[p]] > nums[i])) {

                index = stack[p--];
                t = (pres[i] - pres[stack[p] + 1]) * nums[index];
                res = Math.max(res, t);
            }
            stack[++p] = i;
        }
        return (int) (res % mod);
    }

}
