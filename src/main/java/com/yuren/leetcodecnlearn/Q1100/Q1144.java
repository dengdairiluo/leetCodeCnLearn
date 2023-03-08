package com.yuren.leetcodecnlearn.Q1100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-11-13 21:53
 */
public class Q1144 {
    public int movesToMakeZigzag(int[] nums) {
        int ans1 = 0, ans2 = 0;// 偶大， 奇大
        int[] nums1 = nums.clone();// 奇数用
        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) == 0) {// 偶数位置
                if (i + 1 < nums.length && nums[i] <= nums[i + 1]) {// 后大，偶数大不满足，需要增加ans1
                    ans1 += nums[i + 1] - nums[i] + 1;
                    nums[i + 1] = nums[i] - 1;
                }
                if (i + 1 < nums.length && nums1[i] >= nums1[i + 1]) {// 后大，奇数大不满足，需要增加ans2
                    ans2 += nums1[i] - nums1[i + 1] + 1;
                    nums1[i] = nums1[i + 1] - 1;
                }
            } else {// 奇数位置
                if (i + 1 < nums.length && nums[i] >= nums[i + 1]) {// 后大，偶数大不满足，需要增加ans1
                    ans1 += nums[i] - nums[i + 1] + 1;
                    nums[i] = nums[i + 1] - 1;
                }
                if (i + 1 < nums.length && nums1[i] <= nums1[i + 1]) {// 后大，奇数大不满足，需要增加ans2
                    ans2 += nums1[i + 1] - nums1[i] + 1;
                    nums1[i + 1] = nums1[i] - 1;
                }
            }
        }
        return Math.min(ans1, ans2);
    }


}
