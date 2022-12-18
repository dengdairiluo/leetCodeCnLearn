package com.yuren.leetcodecnlearn.Q1100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-09-18 23:48
 */
public class Q1013 {
    public boolean canThreePartsEqualSum(int[] arr) {
        int s = 0;
        for (int num : arr) {
            s += num;
        }
        if (s % 3 != 0) {
            return false;
        }
        int target = s / 3;
        int n = arr.length, i = 0, cur = 0;
        while (i < n) {
            cur += arr[i];
            if (cur == target) {
                break;
            }
            ++i;
        }
        if (cur != target) {
            return false;
        }
        int j = i + 1;
        // 需要满足最后一个数组非空
        while (j + 1 < n) {
            cur += arr[j];
            if (cur == target * 2) {
                return true;
            }
            ++j;
        }
        return false;
    }
}
