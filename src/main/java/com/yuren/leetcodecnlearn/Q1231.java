package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-12-25 02:20
 */
public class Q1231 {
    public boolean check(int[] sweetness, int minSweet, int part) {
        int sweetCnt = 0, partCnt = 0;
        for (int sweet : sweetness) {
            sweetCnt += sweet;
            if (sweetCnt >= minSweet) {
                partCnt++;
                sweetCnt = 0;
            }
        }
        if (partCnt >= part) {
            return true;
        } else {
            return false;
        }
    }

    public int maximizeSweetness(int[] sweetness, int k) {
        int left = 0, right = (int) 1E10, ans = 0;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (check(sweetness, mid, k + 1)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
