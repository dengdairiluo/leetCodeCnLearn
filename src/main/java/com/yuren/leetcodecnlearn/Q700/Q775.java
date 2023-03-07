package com.yuren.leetcodecnlearn.Q700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-06-07 22:16
 */
public class Q775 {
    public boolean isIdealPermutation(int[] a) {
        int n = a.length;
        int floor = n;
        for (int i = n - 1; i >= 2; --i) {
            floor = Math.min(floor, a[i]);
            if (a[i - 2] > floor) {
                return false;
            }
        }
        return true;
    }
}
