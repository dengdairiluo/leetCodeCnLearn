package com.yuren.leetcodecnlearn.Q2300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-04-07 下午11:03
 */
public class Q2342 {
    public int maximumSum(int[] nums) {
        int ans = -1;
        // 至多 9 个 9 相加
        int[] mx = new int[82];
        for (int num : nums) {
            // num 的数位和
            int s = 0;
            // 枚举 num 的每个数位
            for (int x = num; x > 0; x /= 10) {
                s += x % 10;
            }
            // 说明左边也有数位和等于 s 的元素
            if (mx[s] > 0) {
                // 更新答案的最大值
                ans = Math.max(ans, mx[s] + num);
            }
            // 维护数位和等于 s 的最大元素
            mx[s] = Math.max(mx[s], num);
        }
        return ans;
    }
}
