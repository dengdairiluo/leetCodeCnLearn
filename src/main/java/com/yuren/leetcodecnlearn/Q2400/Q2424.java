package com.yuren.leetcodecnlearn.Q2400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-05-20 下午11:54
 */
public class Q2424 {
    int[] arr;
    int ans = 0;

    public Q2424(int n) {
        arr = new int[n + 2];
    }

    public void upload(int video) {
        arr[video] = 1;
    }

    public int longest() {
        while (arr[ans + 1] == 1) {
            ans++;
        }
        return ans;
    }
}
