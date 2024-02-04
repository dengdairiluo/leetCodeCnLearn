package com.yuren.leetcodecnlearn.Q2200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-02-04 22:56
 */
public class Q2216 {
    public int minDeletion(int[] nums) {
        int len = nums.length;
        int res = 0;
        int ptr = 0, runner = 1;
        while (runner < len) {
            if (nums[ptr] != nums[runner]) {
                runner += 2;
                ptr += 2;
            } else {
                while (runner < len && nums[ptr] == nums[runner]) {
                    res += 1;
                    runner += 1;
                }
                ptr = runner + 1;
                runner += 2;
            }
        }
        // return res;
        return (len - res) % 2 == 0 ? res : res + 1;
    }
}
