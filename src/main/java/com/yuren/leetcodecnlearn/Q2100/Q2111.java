package com.yuren.leetcodecnlearn.Q2100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-13 22:34
 */
public class Q2111 {
    public int kIncreasing(int[] arr, int k) {
        int n = arr.length, ans = 0;
        int[] f = new int[n / k + 1];
        for (int i = 0; i < k; i++) {
            int size = 0, cnt = 0;
            for (int j = i; j < n; j += k) {
                int x = arr[j];
                cnt++;
                if (size == 0 || x >= f[size - 1]) {
                    f[size++] = x;
                } else {
                    int l = 0, r = size - 1;
                    while (l < r) {
                        int m = (l + r) >> 1;
                        if (f[m] > x) {
                            r = m;
                        } else {
                            l = m + 1;
                        }
                    }
                    f[l] = x;
                }
            }
            ans += (cnt - size);
        }
        return ans;
    }
}
