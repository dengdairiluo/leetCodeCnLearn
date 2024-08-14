package com.yuren.leetcodecnlearn.Q2500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-08-15 01:14
 */
public class Q2598 {
    public int findSmallestInteger(int[] nums, int value) {
        int[] counts = new int[value];
        for (int num : nums) {
            int remainder = (num % value + value) % value;
            counts[remainder]++;
        }
        long smallest = Integer.MAX_VALUE;
        for (int i = 0; i < value; i++) {
            long missing = (long) value * counts[i] + i;
            smallest = Math.min(smallest, missing);
        }
        return (int) smallest;
    }
}
