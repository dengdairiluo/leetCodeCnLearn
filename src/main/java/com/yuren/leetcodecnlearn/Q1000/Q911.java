package com.yuren.leetcodecnlearn.Q1000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-08-07 22:40
 */
public class Q911 {
    private final int[] times;
    private final int[] ans;

    public Q911(int[] persons, int[] times) {
        this.times = times;
        ans = new int[times.length];
        int[] cnts = new int[times.length];
        int cur = -1;
        for (int i = 0; i < times.length; i++) {
            cnts[persons[i]]++;
            if (cur == -1 || cnts[persons[i]] >= cnts[cur]) {
                cur = persons[i];
            }
            ans[i] = cur;
        }
    }

    public int q(int t) {
        int l = 0, r = times.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (times[mid] <= t) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return ans[l - 1];
    }
}
