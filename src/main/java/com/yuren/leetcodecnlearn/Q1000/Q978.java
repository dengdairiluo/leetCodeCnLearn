package com.yuren.leetcodecnlearn.Q1000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-09-06 23:45
 */
public class Q978 {
    public int maxTurbulenceSize(int[] arr) {
        int len = arr.length;
        if (len == 1) {
            return 1;
        }
        int ans = arr[0] == arr[1] ? 1 : 2;
        if (len == 2) {
            return ans;
        }
        int flag = Integer.compare(arr[0], arr[1]);
        for (int i = 2, cur = ans; i < len; i++) {
            int n0 = arr[i - 1], n1 = arr[i];
            if (n0 == n1) {
                cur = 1;
                flag = 0;
            } else if (n0 > n1) {
                if (flag <= 0) {
                    cur += 1;
                } else {
                    cur = 2;
                }
                flag = 1;
            } else {
                if (flag >= 0) {
                    cur += 1;
                } else {
                    cur = 2;
                }
                flag = -1;
            }
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}
