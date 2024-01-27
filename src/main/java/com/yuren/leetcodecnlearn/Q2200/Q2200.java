package com.yuren.leetcodecnlearn.Q2200;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-01-27 21:56
 */
public class Q2200 {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n = nums.length;
        int l = 0, r = 0;

        List<Integer> res = new ArrayList<>();

        for (int j = 0; j < n; j++) {
            if (nums[j] == key) {
                l = Math.max(r, j - k);
                r = Math.min(n - 1, j + k) + 1;


                for (int i = l; i < r; i++) {
                    res.add(i);
                }

            }
        }
        return res;

    }
}
