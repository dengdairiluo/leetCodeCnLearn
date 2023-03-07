package com.yuren.leetcodecnlearn.Q200;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-10-20 23:05
 */
public class Q228 {
    public List<String> summaryRanges(int[] nums) {

        ArrayList<String> list = new ArrayList<>();
        int len = nums.length;

        if (len == 0) return list;

        int start = 0, end = 0;
        for (int i = 1; i < len; i++) {

            if (nums[end] + 1 == nums[i]) {
                end++;
                continue;
            }

            // 意思就是如果 数组不连续，那么就要往list里面加
            if (end == start) {
                list.add(nums[start] + "");
            } else {
                list.add(nums[start] + "->" + nums[end]);
            }
            start = end + 1;
            end = start;
        }

        if (end == start) {
            list.add(nums[start] + "");
        } else {
            list.add(nums[start] + "->" + nums[end]);
        }

        return list;
    }
}
