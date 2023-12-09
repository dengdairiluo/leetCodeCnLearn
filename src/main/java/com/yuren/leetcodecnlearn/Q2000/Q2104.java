package com.yuren.leetcodecnlearn.Q2000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-10 00:06
 */
public class Q2104 {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long res = 0;
        for (int i = 0; i < n; i++) {
            int l = i - 1, r = i + 1;
            if (l >= 0 && nums[l] < nums[i]) {
                do l--;
                while (l >= 0 && nums[l] < nums[i]);
            }
            if (r < n && nums[r] <= nums[i]) {
                do r++;
                while (r < n && nums[r] <= nums[i]);
            }
            res += (long) nums[i] * (i - l) * (r - i);
            l = i - 1;
            r = i + 1;
            while (l >= 0 && nums[l] > nums[i]) {
                l--;
            }
            while (r < n && nums[r] >= nums[i]) {
                r++;
            }
            res -= (long) nums[i] * (i - l) * (r - i);
        }
        return res;
    }
}
