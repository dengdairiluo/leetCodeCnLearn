package com.yuren.leetcodecnlearn;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-09-21 23:34
 */
public class Q1018 {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int len = nums.length;
        List<Boolean> ans = new ArrayList<>();
        int num = 0;
        for (int j : nums) {
            num <<= 1;
            num |= j;
            num %= 5;
            ans.add(num == 0);
        }
        return ans;
    }
}
