package com.yuren.leetcodecnlearn.Q2100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-01-15 22:38
 */
public class Q2176 {
    public int countPairs(int[] nums, int k) {
        int index = nums.length - 1;
        int[] indices = new int[101];
        int ans = 0;
        for (int i = index; i >= 0; i--) {
            // nums的元素值
            int val = nums[i];
            // 上一次该值的索引
            int before = indices[val];
            for (int j = before; j > i; j = nums[j]) {
                if (i * j % k == 0)
                    ans++;
            }
            // 将索引反向保存到nums
            nums[i] = before;
            // 保存最近一次索引
            indices[val] = i;
        }
        return ans;
    }

}
