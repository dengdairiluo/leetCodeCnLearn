package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-07-31 19:11
 */
public class Q260 {

    public int[] singleNumber(int[] nums) {
        int bitmask = 0;
        //把数组中的所有元素全部都异或一遍
        for (int num : nums) {
            bitmask ^= num;
        }
        //因为异或运算的结果不一定都是2的n次幂，
        //在二进制中可能会有多个1，为了方便计算
        //我们只需保留其中的任何一个1，其他的都
        //让他变为0，这里保留的是最右边的1
        bitmask &= -bitmask;
        int[] rets = {0, 0};
        for (int num : nums) {
            //然后再把数组分为两部分，每部分在
            //分别异或
            if ((num & bitmask) == 0) {
                rets[0] ^= num;
            } else {
                rets[1] ^= num;
            }
        }
        return rets;

    }
}
