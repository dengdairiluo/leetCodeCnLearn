package com.yuren.leetcodecnlearn.Q2500;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-07-14 下午11:26
 */
public class Q2537 {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        long ans = 0;
        int left = 0, pairs = 0;
        for (int x : nums) {
            pairs += cnt.getOrDefault(x, 0);
            cnt.merge(x, 1, Integer::sum); // 移入右端点
            while (pairs - cnt.get(nums[left]) + 1 >= k)
                pairs -= cnt.merge(nums[left++], -1, Integer::sum); // 移出左端点
            if (pairs >= k) ans += left + 1;
        }
        return ans;
    }
}
