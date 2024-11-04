package com.yuren.leetcodecnlearn.Q2700;

import java.util.TreeMap;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-11-04 23:41
 */
public class Q2762 {
    public long continuousSubarrays(int[] nums) {
        long ans = 0;
        TreeMap<Integer, Integer> t = new TreeMap<Integer, Integer>();
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            t.merge(nums[right], 1, Integer::sum);
            while (t.lastKey() - t.firstKey() > 2) {
                int y = nums[left++];
                if (t.get(y) == 1) t.remove(y);
                else t.merge(y, -1, Integer::sum);
            }
            ans += right - left + 1;
        }
        return ans;
    }
}
