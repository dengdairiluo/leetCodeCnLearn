package com.yuren.leetcodecnlearn.Q2400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-06-23 下午11:44
 */
public class Q2495 {
    public long evenProduct(int[] nums) {
        int left = -1;
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            // 偶数匹配所有值，并刷新左端点
            if (nums[i] % 2 == 0) {
                sum += i + 1;
                left = i;
            }
            // 奇数找到最近的偶数进行配对，加入最近偶数之前的所有值
            else {
                sum += left + 1;
            }
        }
        return sum;
    }
}
