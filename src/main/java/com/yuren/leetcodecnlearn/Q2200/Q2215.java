package com.yuren.leetcodecnlearn.Q2200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-02-03 23:09
 */
public class Q2215 {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<List<Integer>> answer = Arrays.asList(list1, list2);
        int[] temp = new int[2001];
        //在临时数组中将nums1中出现的数字设为1,由于可能有负数，所以我们在此基础上加上1000保证下标合理
        for (int num : nums1) {
            temp[num + 1000] = 1;
        }
        for (int num : nums2) {
            if (temp[num + 1000] == 0) {
                list2.add(num);
            }
            //避免重复添加，应将当前位置设置为其他数
            temp[num + 1000] = 2;
        }
        for (int num : nums1) {
            if (temp[num + 1000] == 1) {
                list1.add(num);
            }
            //避免重复
            temp[num + 1000] = 0;
        }
        return answer;
    }
}
