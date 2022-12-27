package com.yuren.leetcodecnlearn.Q1600;

public class Q1512 {
    public int numIdenticalPairs(int[] nums) {
        int[] table = new int[101];
        int count = 0;
        for (int num : nums) {
            count += table[num];
            table[num]++;
        }

        return count;
    }
}
