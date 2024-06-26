package com.yuren.leetcodecnlearn.Q2100;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-01-09 22:21
 */
public class Q2164 {
    public int[] sortEvenOdd(int[] nums) {
        int s1 = 0;
        int s2 = 0;
        if (nums.length % 2 == 0) {
            s1 = s2 = nums.length / 2;
        } else {
            s1 = nums.length / 2;
            s2 = nums.length / 2 + 1;
        }
        // 奇
        int[] a1 = new int[s1];
        // 偶
        int[] a2 = new int[s2];
        int[] res = new int[nums.length];
        int idx = 0;
        for (int i = 0; i < nums.length; ) {
            a2[idx] = nums[i++];
            if (i == nums.length) break;
            a1[idx] = nums[i++];
            idx++;
        }
        Arrays.sort(a1);
        Arrays.sort(a2);
        int idx1 = a1.length - 1;
        int idx2 = 0;
        for (int i = 0; i < nums.length; ) {
            res[i++] = a2[idx2++];
            if (i == nums.length) break;
            res[i++] = a1[idx1--];
        }
        return res;
    }
}
