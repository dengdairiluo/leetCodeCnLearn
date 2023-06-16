package com.yuren.leetcodecnlearn.Q1600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-06-16 23:53
 */
public class Q1695 {
    public int maximumUniqueSubarray(int[] nums) {
        boolean[] map = new boolean[10010];
        int left = 0;
        int ans = 0;
        int sum = 0;
        int n = nums.length;
        for (int v : nums) {
            sum += v;
            if (map[v]) {
                while (nums[left] != v) {
                    sum -= nums[left];
                    map[nums[left]] = false;
                    left++;
                }
                sum -= nums[left++];
            } else {
                map[v] = true;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
