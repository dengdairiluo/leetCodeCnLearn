package com.yuren.leetcodecnlearn.Q2500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-07-31 下午11:49
 */
public class Q2570 {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int[] temp = new int[1001];
        int res = 0;
        for (int[] value : nums1) {
            if (temp[value[0]] == 0) res++;
            temp[value[0]] += value[1];
        }
        for (int[] ints : nums2) {
            if (temp[ints[0]] == 0) res++;
            temp[ints[0]] += ints[1];
        }
        int[][] ans = new int[res][2];
        int j = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != 0) {
                ans[j][0] = i;
                ans[j][1] = temp[i];
                j++;
            }
        }
        return ans;
    }
}
