package com.yuren.leetcodecnlearn.Q2200;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-02-26 23:45
 */
public class Q2261 {
    public int countDistinct(int[] nums, int k, int p) {
        int ans = 0;
        Set<String> set = new HashSet<>();//去重使用
        for (int i = 0; i < nums.length; i++) {
            int cnt = 0;//保存当前子串中可被 p 整除的元素的数量
            StringBuilder builder = new StringBuilder();
            for (int j = i; j >= 0; j--) {
                builder.append(nums[j] + " ");//必须要空格，不然不能去重
                if (nums[j] % p == 0) cnt++;
                if (cnt <= k && !set.contains(builder.toString())) {
                    set.add(builder.toString());//使用HashSet进行子数组进行去重
                    ans++;
                }
            }
        }

        return ans;
    }
}
