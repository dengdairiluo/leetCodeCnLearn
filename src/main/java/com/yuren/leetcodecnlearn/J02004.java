package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-08-08 21:18
 */
public class J02004 {
    public int singleNumber(int[] nums) {
        //---- 三进制
        int one = 0;
        int two = 0;


        for (int num : nums) {
            one = one ^ (~two & num);
            two = two ^ (~one & num);

        }

        return one;

    }
}
