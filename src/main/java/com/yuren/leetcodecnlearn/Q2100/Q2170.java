package com.yuren.leetcodecnlearn.Q2100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-01-14 22:49
 */
public class Q2170 {
    public int minimumOperations(int[] nums) {
        int a = 0, b = 0, c = 0, d = 0;
        int[] cnt1 = new int[100010];
        int[] cnt2 = new int[100010];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            if (i % 2 == 0) {
                cnt1[x]++;
                if (cnt1[x] > cnt1[a]) {
                    b = a;
                    a = x;
                } else if (x != a && cnt1[x] > cnt1[b]) {
                    b = x;
                }
            } else {
                cnt2[x]++;
                if (cnt2[x] > cnt2[c]) {
                    d = c;
                    c = x;
                } else if (x != c && cnt2[x] > cnt2[d]) {
                    d = x;
                }
            }

        }
        if (a != c) {
            return n - cnt1[a] - cnt2[c];
        }
        return n - Math.max(cnt1[a] + cnt2[d], cnt1[b] + cnt2[c]);
    }
}
