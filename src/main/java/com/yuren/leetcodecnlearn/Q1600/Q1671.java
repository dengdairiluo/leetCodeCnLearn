package com.yuren.leetcodecnlearn.Q1600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-06-08 23:58
 */
public class Q1671 {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] maxLeft = getMaxLen(nums, 0, n, 1);
        int[] maxRight = getMaxLen(nums, n - 1, -1, -1);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (maxLeft[i] > 1 && maxRight[i] > 1) {
                ans = Math.min(ans, n - maxLeft[i] - maxRight[i] + 1);
            }
        }
        return ans;
    }

    private int[] getMaxLen(int[] nums, int start, int end, int add) {
        int n = nums.length;
        int[] maxItems = new int[n];
        int len = 0;
        int[] maxLen = new int[n];
        for (int i = start; i != end; i += add) {
            if (len == 0 || nums[i] > maxItems[len - 1]) {
                maxItems[len++] = nums[i];
                maxLen[i] = len;
            } else {
                int left = 0;
                int right = len - 1;
                while (left < right) {
                    int mid = (right - left) / 2 + left;
                    if (maxItems[mid] < nums[i]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                maxLen[i] = right + 1;
                maxItems[right] = nums[i];
            }
        }
        return maxLen;
    }
}
