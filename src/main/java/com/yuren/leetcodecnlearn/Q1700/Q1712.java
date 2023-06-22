package com.yuren.leetcodecnlearn.Q1700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-06-22 23:34
 */
public class Q1712 {
    public static final int MOD = (int) (1e9 + 7);

    public int waysToSplit(int[] nums) {
        int n = nums.length;
        // 前缀和
        int[] p = new int[n + 1];
        for (int i = 0, t = 0; i < n; i++) {
            t += nums[i];
            p[i + 1] = t;
        }
        long res = 0;
        // 双指针，注意 k 的初始值需要比 j 小 1
        for (int i = 1, j = 2, k = 1; i < n - 1 && p[i] * 3 <= p[n]; i++) {
            int left = p[i];
            // 两个分割点必须保持前后顺序
            j = Math.max(i + 1, j);
            while (j < n && p[j] - p[i] < left) {
                j++;
            }
            while (k < n - 1 && p[k + 1] - p[i] <= p[n] - p[k + 1]) {
                k++;
            }
            // line 21 : 不能使用 if (k < j) break; 提前结束循环
            res += k - j + 1;
        }
        return (int) (res % MOD);
    }
}
