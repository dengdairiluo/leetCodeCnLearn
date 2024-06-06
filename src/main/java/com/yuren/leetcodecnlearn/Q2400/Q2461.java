package com.yuren.leetcodecnlearn.Q2400;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-06-06 下午11:11
 */
public class Q2461 {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long rst = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        if (map.size() == k) {
            rst = Math.max(rst, sum);
        }

        for (int i = k; i < n; i++) {
            // 右指针右移
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);


            // 左指针右移
            sum -= nums[i - k];
            int cnt = map.get(nums[i - k]);
            if (cnt == 1) {
                map.remove(nums[i - k]);
            } else {
                map.put(nums[i - k], cnt - 1);
            }

            if (map.size() == k) {
                rst = Math.max(rst, sum);
            }
        }

        return rst;
    }

}
