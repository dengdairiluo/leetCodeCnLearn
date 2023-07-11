package com.yuren.leetcodecnlearn.Q1700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-07-11 22:33
 */
public class Q1760 {
    public int minimumSize(int[] nums, int maxOperations) {
        int ans = 0;
        int l = 1, r = 0;
        for (int num : nums) {
            r = Math.max(r, num);
        }
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int tot = 0;
            for (int num : nums) {
                tot += (num - 1) / mid;
            }
            if (tot > maxOperations) {
                l = mid + 1;
            } else if (tot <= maxOperations) {
                r = mid - 1;
            }
        }
        return l;
    }
}
