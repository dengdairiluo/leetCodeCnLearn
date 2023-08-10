package com.yuren.leetcodecnlearn.Q1800;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-08-10 23:53
 */
public class Q1838 {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0;
        int need = 0, cnt = 0, base = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            need += (nums[i] - base) * cnt;
            while (need > k) {
                cnt--;
                need -= nums[i] - nums[j];
                j++;
            }
            base = nums[i];
            cnt++;
            res = Math.max(res, cnt);
        }
        return res;
    }
}
