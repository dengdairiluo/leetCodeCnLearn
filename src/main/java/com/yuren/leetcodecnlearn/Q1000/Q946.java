package com.yuren.leetcodecnlearn.Q1000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-08-20 23:54
 */
public class Q946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int l = popped.length;
        int left = -1, right = 0;

        for (int i : popped) {
            if (left >= 0 && i == pushed[left]) {
                left--;
                continue;
            }
            if (right < l && i == pushed[right]) {
                right++;
                continue;
            }

            while (right < l && i != pushed[right]) {
                pushed[++left] = pushed[right++];
            }
            if (right == l) {
                return false;
            }
            right++;
        }
        return true;
    }
}
