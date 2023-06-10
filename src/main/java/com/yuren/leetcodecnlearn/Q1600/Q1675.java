package com.yuren.leetcodecnlearn.Q1600;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-06-11 02:27
 */
public class Q1675 {
    public int minimumDeviation(int[] nums) {
        int mi = 0;
        for (int num : nums) {
            int tmp = num;
            while ((tmp & 1) == 0) {
                tmp >>= 1;
            }
            mi = Math.max(tmp, mi);
        }

        int hi = mi;
        int lo = mi;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 1) {
                nums[i] <<= 1;
            }
            int tmp = nums[i];
            while ((tmp & 1) == 0) {
                tmp >>= 1;
            }
            if (tmp >= mi) {
                hi = Math.max(hi, tmp);
                nums[i] = lo;
            } else if (nums[i] <= mi) {
                lo = Math.min(lo, nums[i]);
                nums[i] = lo;
            } else {
                while ((tmp << 1) < mi) {
                    tmp <<= 1;
                }
                nums[i] = tmp;
            }
        }

        Arrays.sort(nums);
        int res = hi - Math.min(lo, nums[0]);
        int max = hi;
        for (int i = 0; i < nums.length && nums[i] < lo; i++) {
            max = Math.max(max, nums[i] << 1);
            res = Math.min(res, max - nums[i + 1]);
        }

        return res;
    }
}
