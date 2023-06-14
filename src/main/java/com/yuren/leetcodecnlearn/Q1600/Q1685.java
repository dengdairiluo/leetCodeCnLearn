package com.yuren.leetcodecnlearn.Q1600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-06-13 23:32
 */
public class Q1685 {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int sum = 0;
        int[] prefixSum = new int[nums.length];
        //计算前缀和
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            prefixSum[i] = sum;
        }
        //计算每个数的差绝对值之和
        int[] output = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            // int sumOfLeftDifferences = (i+1)*nums[i]-prefixSum[i];
            // int sumOfRightDifferences = prefixSum[nums.length-1]-prefixSum[i]-nums[i]*(nums.length-1-i);
            // sumOfDifferences =  sumOfLeftDifferences+sumOfRightDifferences;
            output[i] = (i + 1) * nums[i] - prefixSum[i] + prefixSum[nums.length - 1] - prefixSum[i] - nums[i] * (nums.length - 1 - i);
        }
        return output;
    }
}
