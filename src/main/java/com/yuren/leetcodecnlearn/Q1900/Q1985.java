package com.yuren.leetcodecnlearn.Q1900;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-10-12 22:29
 */
public class Q1985 {
    public String kthLargestNumber(String[] nums, int k) {

        Arrays.sort(nums, (a, b) -> a.length() == b.length() ? b.compareTo(a) : b.length() - a.length());
        return nums[k - 1];
    }
}
