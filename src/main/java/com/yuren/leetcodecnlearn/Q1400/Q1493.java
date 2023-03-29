package com.yuren.leetcodecnlearn.Q1400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-03-29 23:29
 */
public class Q1493 {
    public int longestSubarray(int[] nums) {
        int low = 0, high = 0, n = nums.length;
        int latest0 = -1;
        int curLen = 0, maxLen = 0;
        while (high < n) {
            if (0 == nums[high]) {
                if (latest0 > -1) {
                    low = 1 + latest0;
                }
                latest0 = high;
                //不能加1,因为不算0,只算1
                curLen = high - low;
            } else {
                curLen++;
            }
            high++;
            maxLen = Math.max(maxLen, curLen);
        }
        if (latest0 == -1) {
            maxLen -= 1;
        }
        return maxLen;
    }
}
