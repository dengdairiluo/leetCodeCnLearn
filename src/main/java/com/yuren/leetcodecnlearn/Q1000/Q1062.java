package com.yuren.leetcodecnlearn.Q1000;

import java.util.HashSet;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-10-08 23:35
 */
public class Q1062 {
    public int search(int l, int a, long modulus, int n, int[] nums) {
        // compute the hash of string S[:L]
        long h = 0;
        for (int i = 0; i < l; ++i) {
            h = (h * a + nums[i]) % modulus;
        }

        // already seen hashes of strings of length L
        HashSet<Long> seen = new HashSet<>();
        seen.add(h);
        // const value to be used often : a**L % modulus
        long aL = 1;
        for (int i = 1; i <= l; ++i) {
            aL = (aL * a) % modulus;
        }

        for (int start = 1; start < n - l + 1; ++start) {
            // compute rolling hash in O(1) time
            h = (h * a - nums[start - 1] * aL % modulus + modulus) % modulus;
            h = (h + nums[start + l - 1]) % modulus;
            if (seen.contains(h)) {
                return start;
            }
            seen.add(h);
        }
        return -1;
    }

    public int longestRepeatingSubstring(String s) {
        int n = s.length();
        // convert string to array of integers
        // to implement constant time slice
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = (int) s.charAt(i) - (int) 'a';
        }
        // base value for the rolling hash function
        int a = 26;
        // modulus value for the rolling hash function to avoid overflow
        long modulus = (long) Math.pow(2, 24);

        // binary search, L = repeating string length
        int left = 1, right = n;
        int l;
        while (left <= right) {
            l = left + (right - left) / 2;
            if (search(l, a, modulus, n, nums) != -1) {
                left = l + 1;
            } else {
                right = l - 1;
            }
        }

        return left - 1;
    }
}
