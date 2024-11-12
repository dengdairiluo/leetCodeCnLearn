package com.yuren.leetcodecnlearn.Q2700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-11-12 23:45
 */
public class Q2778 {
    public int sumOfSquares(int[] nums) {
        int total = 0;
        int index = 0;
        int length = nums.length;
        while(length>0){

            if (nums.length%(index+1)==0  ){
                total+= nums[index]*nums[index];
                System.out.println(index);
            }
            index++;
            length--;

        }
        return total;

    }
}
