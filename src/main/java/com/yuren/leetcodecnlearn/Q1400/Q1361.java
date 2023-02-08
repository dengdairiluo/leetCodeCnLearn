package com.yuren.leetcodecnlearn.Q1400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-02-08 23:49
 */
public class Q1361 {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] flag = new int[n];
        int root = 0;
        for (int i = 0; i < n; i++) {
            int t = leftChild[i];
            if (t == root) {
                root = i;
            }
            if (t > -1) {
                if (flag[t] == 0) {
                    flag[t] = 1;
                } else {
                    return false;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            int t = rightChild[i];
            if (t == root) {
                root = i;
            }
            if (t > -1) {
                if (flag[t] == 0) {
                    flag[t] = 1;
                } else {
                    return false;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += flag[i];
        }
        return count == n - 1 && flag[root] == 0;
    }
}
