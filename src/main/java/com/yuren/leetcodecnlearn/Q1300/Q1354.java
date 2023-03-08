package com.yuren.leetcodecnlearn.Q1300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-02-07 23:38
 */
public class Q1354 {
    public boolean isPossible(int[] target) {
        if (target.length <= 1 && target[0] != 1) {
            return false;
        }
        int indexMax = 0;
        int sum = 0;
        for (int tar : target) {
            sum += tar;
        }
        while (sum > target.length) {
            for (int i = 0; i < target.length; i++) {
                if (target[i] > target[indexMax]) {
                    indexMax = i;
                }
            }
            int temp = target[indexMax];
            if (sum - target[indexMax] == 1) {
                target[indexMax] = 1;
            } else {
                target[indexMax] = target[indexMax] % (sum - target[indexMax]);
            }
            if (target[indexMax] < 1 || target[indexMax] == temp) {
                return false;
            }
            sum = sum - temp + target[indexMax];
        }
        return sum == target.length;
    }
}
