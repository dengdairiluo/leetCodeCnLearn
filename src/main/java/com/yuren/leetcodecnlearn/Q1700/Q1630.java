package com.yuren.leetcodecnlearn.Q1700;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-06-27 23:14
 */
public class Q1630 {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> list = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            int[] arr = new int[r[i] - l[i] + 1];
            int index = 0;
            //先根据l,r创建子数组
            for (int j = l[i]; j <= r[i]; j++) {
                arr[index++] = nums[j];
            }
            //再排序
            Arrays.sort(arr);
            int n = arr[1] - arr[0];
            int k = 1;
            //再判断是否为等差数列
            for (k = 1; k < arr.length - 1; k++) {
                if (arr[k + 1] - arr[k] != n) {
                    list.add(false);
                    break;
                }
            }
            if (k >= arr.length - 1) {
                list.add(true);
            }
        }
        return list;

    }
}
