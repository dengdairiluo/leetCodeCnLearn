package com.yuren.leetcodecnlearn.Q1200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-15 22:57
 */
public class Q1287 {
    public int findSpecialInteger(int[] arr) {
        int len = arr.length;

        int slowIdx = 0;
        int slowValue = arr[0];
        int fastIdx = 0;
        int fastValue;
        while (fastIdx < len) {
            fastValue = arr[fastIdx];
            if (fastValue != slowValue) {
                if ((fastIdx - slowIdx) * 4 > len) {
                    return slowValue;
                } else {
                    slowIdx = fastIdx;
                    slowValue = fastValue;
                }
            }
            fastIdx++;
        }

        if ((fastIdx - slowIdx) * 4 > len) {
            return slowValue;
        }

        return 0;
    }
}
