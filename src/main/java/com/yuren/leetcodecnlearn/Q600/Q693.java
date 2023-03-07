package com.yuren.leetcodecnlearn.Q600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-05-03 23:13
 */
public class Q693 {
    public boolean hasAlternatingBits(int n) {
        int cur = -1;
        while (n != 0) {
            int u = n & 1;
            if ((cur ^ u) == 0) return false;
            cur = u;
            n >>= 1;
        }
        return true;
    }
}
