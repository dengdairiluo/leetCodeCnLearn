package com.yuren.leetcodecnlearn.Q100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-09-27 22:51
 */
public class Q149 {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) {
            return n;
        }

        // 返回值
        int max = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int count = 2;
                int[] a = points[i];
                int[] b = points[j];
                int abDeltaX = b[0] - a[0];
                int abDeltaY = b[1] - a[1];

                for (int k = j + 1; k < n; k++) {
                    int[] c = points[k];
                    int acDeltaX = c[0] - a[0];
                    int acDeltaY = c[1] - a[1];
                    // 判断abDeltaY/abDeltaX是否等于acDeltaY/acDeltaX
                    // 转换成乘法为：判断abDeltaY * acDeltaX 是否等于 abDeltaX * acDeltaY
                    // 这样可以消除精度问题
                    if (abDeltaY * acDeltaX == abDeltaX * acDeltaY) {
                        count++;
                    }
                }
                max = Math.max(max, count);
            }
        }

        return max;
    }
}
