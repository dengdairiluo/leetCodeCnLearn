package com.yuren.leetcodecnlearn.Q2000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-11-20 22:36
 */
public class Q2064 {
    private static final int MAX = (int) 1e5;

    public int minimizedMaximum(int n, int[] quantities) {
        int left = 1, right = MAX;
        while (left < right) {
            int mid = ((right - left) >>> 1) + left;
            if (check(n, quantities, mid)) {
                //每个人需要少分一点，[left, mid)
                right = mid;
            } else {
                //每个人分的可以多分一点，[mid + 1, right)
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean check(int n, int[] quantities, int c) {
        for (int i : quantities) {
            n -= (i + c - 1) / c;
            if (n < 0) {
                //每个人最多分c件，不能分完，每个人需要多分点
                return false;
            }
        }
        //每个人最多分c件，可以分完，尝试每个人少分点
        return true;
    }

}
