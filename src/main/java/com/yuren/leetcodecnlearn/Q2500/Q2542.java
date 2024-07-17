package com.yuren.leetcodecnlearn.Q2500;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-07-17 下午11:41
 */
public class Q2542 {
    public long maxScore(int[] nums1, int[] nums2, int k) {

        int max2 = 0;
        for (int x : nums2)
            if (x > max2) max2 = x;

        List<Integer>[] list = new List[max2 + 1];
        int n = nums2.length;
        for (int i = 0; i < n; ++i) {
            int num2 = nums2[i];
            if (list[num2] == null)
                list[num2] = new ArrayList<Integer>();
            list[num2].add(nums1[i]);
        }

        int max1 = 0;
        for (int x : nums1)
            if (x > max1) max1 = x;

        int[] count = new int[max1 + 1];
        int min1 = -1;

        long sum = 0, result = 0;
        for (int num2 = max2; num2 > 0; --num2) {
            if (list[num2] == null) continue;

            for (int num1 : list[num2]) {
                if (num1 < min1) continue;
                sum += num1;
                count[num1]++;

                if (--k <= 0) {
                    result = Math.max(result, sum * num2);
                    if (min1 == -1) ++min1;
                    while (count[min1] == 0) ++min1;
                    sum -= min1;
                    count[min1]--;
                }
            }
        }

        return result;
    }
}
