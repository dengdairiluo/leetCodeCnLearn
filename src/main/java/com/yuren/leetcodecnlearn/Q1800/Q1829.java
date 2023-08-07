package com.yuren.leetcodecnlearn.Q1800;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-08-07 23:30
 */
public class Q1829 {
    //首先明确一个事实，异或完的最大值一定是2的maximunbit次方 - 1
    //因为只需要根据异或结果，把0改成1就能做到
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        //记录下k不能超过的最大值 + 1
        int max = 1 << maximumBit;
        //用于返回结果
        int[] res = new int[nums.length];
        //遍历一遍数组，记录下所有元素的异或结果
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp ^= nums[i];
        }
        //开始填返回数组
        for (int i = 0; i < nums.length; i++) {
            //所有元素疑惑结果有三种可能
            //第一种：temp > max - 1
            //此时temp高于max的位有1，需要把这些1的影响抹除，让它变成第三种情况
            if (temp > max - 1) {
                //用一个临时变量存下temp，防止temp被改变
                int a = temp;
                //用于记录下抹除影响之后的答案
                int num = 0;
                //循环终止条件是不能超过max
                while (num < max) {
                    //（a & a - 1）的作用是将最后一位1变成0
                    // a ^ (a & a - 1)的作用是只留下最后一个1
                    //在不超过max的前提下，保留最后一位1的影响
                    num += a ^ (a & a - 1);
                    //原数删掉最后一位1，继续看下一个1是否符合
                    a &= a - 1;
                }
                //此时将小于max的全部的1的影响拿到，高于max的1 的影响去除，变成第三种情况
                res[i] = temp ^ num;
                //第二种：temp == max - 1
                //说明此时temp所有位都是1，已经是最大值，只需要异或0就能得到最大值
            } else if (temp == max - 1) {
                res[i] = 0;
                //第三种：temp < max - 1
                //说明此时temp高于max的位全为0，只需要把低于max的位的0全部改成1即可
                //利用异或运算的性质，异或同一个数两次等于原数
            } else {
                res[i] = temp ^ max - 1;
            }
            //最后要把最后一个删掉，只需要在原基础上异或最后一个元素即可抹掉它的影响
            temp ^= nums[nums.length - 1 - i];
        }
        return res;
    }

}
