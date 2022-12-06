package com.yuren.leetcodecnlearn.Q200;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-10-02 23:37
 */
public class Q163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<>();
        int n = nums.length;
        if (n == 0) {
            ans.add(helper(lower - 1, upper + 1));
            return ans;
        }
        if (lower < nums[0]) {
            ans.add(helper(lower - 1, nums[0]));
        }
        for (int idx = 0; idx < n - 1; ++idx) {
            if (nums[idx] + 1 != nums[idx + 1]) {
                ans.add(helper(nums[idx], nums[idx + 1]));
            }
        }
        if (upper > nums[n - 1]) {
            ans.add(helper(nums[n - 1], upper + 1));
        }
        return ans;
    }

    private String helper(int left, int right) {
        StringBuilder builder = new StringBuilder();
        if (left + 2 == right) {
            builder.append(left + 1);
        } else {
            builder.append(left + 1).append("->").append(right - 1);
        }
        return builder.toString();
    }

}
