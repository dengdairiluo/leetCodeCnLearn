package com.yuren.leetcodecnlearn.Q1300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-20 23:44
 */
public class Q1306 {

    boolean[] been;
    boolean ans;
    int len;

    public boolean canReach(int[] arr, int start) {
        len = arr.length;
        been = new boolean[len];
        ans = false;
        this.f(arr, start);
        return ans;
    }

    private void f(int[] arr, int start) {
        if (ans || start < 0 || start >= len || been[start]) {
            return;
        }
        been[start] = true;
        if (arr[start] == 0) {
            ans = true;
            return;
        }
        this.f(arr, start - arr[start]);
        this.f(arr, start + arr[start]);
    }

}
