package com.yuren.leetcodecnlearn.Q800;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-06-20 23:33
 */
public class Q805 {
    public static boolean splitArraySameAverage(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return false;
        }
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        List<int[]> l = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        int depth = 1;// 数组长度为3，a[0]表示最前排的位，a[1]表示它们的和
        for (int i = 0; i < n; i++) {
            int[] temp = new int[2];
            temp[0] = i;
            temp[1] = nums[i];
            if (nums[i] * n == sum) return true;
            if (nums[i] * n < sum && !set.contains(nums[i])) {
                l.add(temp);
                set.add(nums[i]);
            }
        }
        set.clear();
        if (depth >= n / 2) return false;
        depth++;
        while (!l.isEmpty()) {
            List<int[]> lTemp = new ArrayList<>();
            for (int i = 1; i < n; i++) {
                for (int[] temp : l) {
                    if (temp[0] >= i) break;
                    int[] arr = new int[2];
                    arr[0] = i;
                    arr[1] = temp[1] + nums[i];
                    if (arr[1] * n == sum * depth) return true;
                    if (arr[1] * n < sum * depth && !set.contains(arr[1])) {
                        lTemp.add(arr);
                        set.add(arr[1]);
                    }
                }
            }
            if (depth >= n / 2) {
                return false;
            }
            depth++;
            set.clear();
            l = lTemp;
        }
        return false;
    }
}
