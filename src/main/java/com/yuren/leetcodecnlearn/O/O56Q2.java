package com.yuren.leetcodecnlearn.O;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-03-25 22:53
 */
public class O56Q2 {

    private static int singleNumber1(int[] nums) {
        int[] counts = new int[32];
        for (int num : nums) {
            for (int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0, m = 3;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }

    private static int singleNumber2(int[] nums) {
        int one = 0, two = 0;
        for (int x : nums) {
            one = (one ^ x) & ~two;
            two = (two ^ x) & ~one;
        }
        return one;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 3, 3};
        System.out.println(singleNumber1(nums));
        System.out.println(singleNumber2(nums));
    }
}
