package com.yuren.leetcodecnlearn;

import java.util.Random;

public class Q398 {
    private final int[] nums;

    public Q398(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        Random r = new Random();
        int n = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                //计算同一个target的个数
                n++;
                //我们以同一个数字的频数1/n的概率选出其中一个索引
                if (r.nextInt(n) == 0) {
                    index = i;
                }
            }
        }
        return index;
    }
}
