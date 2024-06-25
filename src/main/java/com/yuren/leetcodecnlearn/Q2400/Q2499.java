package com.yuren.leetcodecnlearn.Q2400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-06-25 下午11:51
 */
public class Q2499 {
    public long minimumTotalCost(int[] nums1, int[] nums2) {
        long ans = 0L;
        int swapCnt = 0, modeCnt = 0, mode = 0, n = nums1.length;
        int[] cnt = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            int x = nums1[i];
            if (x == nums2[i]) {
                ans += i;
                ++swapCnt;
                ++cnt[x];
                if (cnt[x] > modeCnt) {
                    modeCnt = cnt[x];
                    mode = x;
                }
            }
        }

        for (int i = 0; i < n && modeCnt * 2 > swapCnt; ++i) {
            int x = nums1[i], y = nums2[i];
            if (x != y && x != mode && y != mode) {
                ans += i;
                ++swapCnt;
            }
        }
        return modeCnt * 2 > swapCnt ? -1 : ans;
    }
}
