package com.yuren.leetcodecnlearn;

import java.util.Arrays;

public class Q1111 {

    private static int[] maxDepthAfterSplit(String seq) {
        int length = seq.length();
        int[] ans = new int[length];
        for (int i = 0; i < length; ++i) {
            ans[i] = i & 1 ^ (seq.charAt(i) == '(' ? 1 : 0);
        }
        return ans;
    }

    public static void main(String[] args) {
        String seq1 = "(()())";
        System.out.println(Arrays.toString(maxDepthAfterSplit(seq1)));
    }
}
