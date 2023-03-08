package com.yuren.leetcodecnlearn.Q1200;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-17 01:21
 */
public class Q1296 {
    public boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;
        //数组的长度模k不等于0，直接返回false
        if (n % k != 0) return false;
        Arrays.sort(nums);
        //哈希表记录nums[i]出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            if (map.containsKey(num)) {
                //获取nums[i]出现的次数
                int cnt = map.get(num);
                int val = num;
                //更新哈希表
                map.remove(num);
                int v = val + k;
                val++;
                //搜索区间[nums[i],nums[i] + k - 1]的数出现的次数是否大于等于nums[i]出现的次数
                while (val != v) {
                    //区间中没有出现的数，直接返回false
                    if (!map.containsKey(val)) {
                        return false;
                    } else {
                        int tmp = map.get(val);
                        //等于nums[i]出现的次数
                        if (tmp == cnt) {
                            map.remove(val);
                            //小于nums[i]出现的次数，直接返回false
                        } else if (tmp < cnt) {
                            return false;
                        } else {//大于nums[i]出现的次数，更新哈希表
                            map.put(val, tmp - cnt);
                        }
                    }
                    val++;
                }
            }
        }
        return true;
    }
}
