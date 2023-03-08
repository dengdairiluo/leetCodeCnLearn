package com.yuren.leetcodecnlearn.Q1300;

import java.util.Arrays;
import java.util.Comparator;

public class Q1365 {

    /**
     * 爆破
     *
     * @param nums
     * @return
     */
    private static int[] smallerNumbersThanCurrent1(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];

        for (int i = 0; i < length; i++) {
            int cnt = 0;
            for (int num : nums) {
                if (num < nums[i]) {
                    cnt++;
                }
            }
            res[i] = cnt;
        }
        return res;
    }

    /**
     * 先排序，然后找左侧第一个小的数的数量
     *
     * @param nums
     * @return
     */
    private static int[] smallerNumbersThanCurrent2(int[] nums) {
        int n = nums.length;

        int[][] data = new int[n][2];
        for (int i = 0; i < n; i++) {
            data[i][0] = nums[i];
            data[i][1] = i;
        }

        Arrays.sort(data, Comparator.comparingInt(o -> o[0]));

        int[] ans = new int[n];
        int prev = -1;
        for (int i = 0; i < n; i++) {
            if (prev == -1 || data[i][0] != data[i - 1][0]) {
                prev = i;
            }
            ans[data[i][1]] = prev;
        }
        return ans;
    }

    /**
     * 计数排序
     *
     * @param nums
     * @return
     */
    private static int[] smallerNumbersThanCurrent3(int[] nums) {
        int[] cnt = new int[101];
        int n = nums.length;
        for (int num : nums) {
            cnt[num]++;
        }
        for (int i = 1; i <= 100; i++) {
            cnt[i] += cnt[i - 1];
        }
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            ret[i] = nums[i] == 0 ? 0 : cnt[nums[i] - 1];
        }
        return ret;

    }

}
