package com.yuren.leetcodecnlearn.Q1600;

import java.util.Arrays;

public class Q1561 {


    private static int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int length = piles.length;
        int rounds = length / 3;
        int coins = 0;
        int index = length - 2;
        for (int i = 0; i < rounds; i++) {
            coins += piles[index];
            index -= 2;
        }
        return coins;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 4, 1, 2, 7, 8};
        System.out.println(maxCoins(nums));
    }
}
