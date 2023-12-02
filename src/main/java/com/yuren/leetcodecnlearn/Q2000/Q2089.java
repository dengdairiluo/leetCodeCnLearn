package com.yuren.leetcodecnlearn.Q2000;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-02 23:31
 */
public class Q2089 {
    public List<Integer> targetIndices(int[] nums, int target) {
        // 目标数出现的次数
        int num = 0;
        // 比目标数小的个数
        int less = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < target) less++;
            if (nums[i] == target) num++;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(less + i);
        }
        return list;
    }
}
