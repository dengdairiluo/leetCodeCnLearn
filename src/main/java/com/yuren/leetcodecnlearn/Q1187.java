package com.yuren.leetcodecnlearn;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-12-01 23:53
 */
public class Q1187 {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        // 将arr2排序，方便进行二分查找
        Arrays.sort(arr2);
        // 由于结果数组严格递增，不可能存在相同元素，可以果断去重
        int n2 = 0;
        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] != arr2[n2]) {
                arr2[++n2] = arr2[i];
            }
        }
        ++n2;
        // 最大可能替换次数为 min(n1, n2) 即两个数组长度的最小值
        int maxStep = Math.min(n1, n2);
        // 构造二维dp数组，dp[i][j]定义：对于子数组arr1，在使用不多于j次替换使得arr1前i个元素的子数组严格递增，前i个元素末尾元素所能达到的最小值
        // arr1 元素个数从0到n1，元素维度长度为 n1+1，替换次数为0到max_step，操作步数维度长度为 max_step+1
        int[][] dp = new int[n1 + 1][maxStep + 1];
        for (int i = 0; i <= n1; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        // 由于 0 <= arr1[i], arr2[i] <= 10^9，最小元素值为0，构造边界-1，方便进行二分查找
        dp[0][0] = -1;
        // 用min_step记录使arr1前i个元素的子数组严格递增的最小操作步数，由于min_step随着i的增大一定单调非递减，所以可以单独提出来
        int min_step = 0;
        for (int i = 1; i <= n1; ++i) {
            int curr_step = Integer.MAX_VALUE; // 用curr_step记录当前使arr1前i个元素的子数组严格递增的最小操作步数
            for (int j = min_step; j <= Math.min(i, maxStep); ++j) {
                // 不进行替换，如果arr1中的当前元素arr1[i-1]比之前i-1个元素构成序列最末尾元素大，直接添加到第i个元素位置
                if (dp[i - 1][j] < arr1[i - 1]) {
                    dp[i][j] = arr1[i - 1];
                }
                // 如果可替换步数大于0，考虑用arr2中元素替换arr1中元素的情况
                if (j > 0) {
                    // 前i-1个元素前j-1步操作后的末尾元素最小值
                    int prev = dp[i - 1][j - 1];
                    // 二分查找arr2中比prev大且最接近prev的元素值
                    // [0, n2-1]
                    int l = 0, r = n2 - 1;
                    while (l < r) {
                        int mid = (l + r) >> 1;
                        if (arr2[mid] <= prev) {
                            l = mid + 1;
                        } else {
                            r = mid;
                        }
                    }
                    // 如果arr2中存在比prev大且最接近prev的元素值
                    if (arr2[l] > prev) {
                        // 取 min(dp[i][j], arr2[r])
                        dp[i][j] = Math.min(dp[i][j], arr2[l]);
                    }
                }
                // 如果可以经过最多j步操作使得arr1前i个元素的子数组严格递增
                if (dp[i][j] != Integer.MAX_VALUE) {
                    // 更新curr_step
                    curr_step = Math.min(curr_step, j);
                }
            }
            // 如果不可以经过最多 min(i, max_step) 步操作使得arr1前i个元素的子数组严格递增
            if (curr_step == Integer.MAX_VALUE) {
                // 如果无法让 arr1 严格递增，返回 -1。
                return -1;
            }
            // 更新min_step
            min_step = curr_step;
        }
        // 返回使 arr1 严格递增所需要的最小操作步数
        return min_step;
    }
}
