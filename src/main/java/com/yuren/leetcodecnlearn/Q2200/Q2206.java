package com.yuren.leetcodecnlearn.Q2200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-01-30 22:24
 */
public class Q2206 {
    public boolean divideArray(int[] nums) {
        //统计数组中元素的个数
        int[] arr = new int[505];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
        }
        //检查数组中元素出现的次数是否都为偶数次
        for (int i = 0; i < arr.length; i++) {
            //出现奇数次不满足 返回false
            if (arr[i] % 2 == 1) {
                return false;
            }
        }
        //所有的次数都不是奇数次 则都是偶数次 满足要求
        return true;
    }
}
