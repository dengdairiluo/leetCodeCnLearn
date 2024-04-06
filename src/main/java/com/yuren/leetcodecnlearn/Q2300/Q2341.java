package com.yuren.leetcodecnlearn.Q2300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-04-06 下午11:45
 */
public class Q2341 {
    public int[] numberOfPairs(int[] nums) {
        int[] cnt = new int[101];
        for (int x : nums) {
            ++cnt[x];
        }
        int s = 0;
        for (int v : cnt) {
            s += v / 2;
        }
        return new int[]{s, nums.length - s * 2};
    }
}
