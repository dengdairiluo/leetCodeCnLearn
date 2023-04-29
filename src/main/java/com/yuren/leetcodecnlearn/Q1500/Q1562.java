package com.yuren.leetcodecnlearn.Q1500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-04-29 22:52
 */
public class Q1562 {
    public int findLatestStep(int[] arr, int m) {
        int n = arr.length;
        if (n == m) {
            return n;
        }

        int[] length = new int[n + 2];

        int result = -1;
        for (int i = 0; i < n; ++i) {
            int x = arr[i];
            int leftLength = length[x - 1];
            int rightLength = length[x + 1];

            if (leftLength == m || rightLength == m) {
                result = i;
            }

            length[x - leftLength] = length[x + rightLength] = leftLength + rightLength + 1;

        }
        return result;
    }
}
