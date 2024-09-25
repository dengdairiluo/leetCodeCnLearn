package com.yuren.leetcodecnlearn.Q2600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-09-25 23:36
 */
public class Q2683 {
    public boolean doesValidArrayExist(int[] derived) {
        int xorValue = 0;
        for (int num : derived) {
            xorValue ^= num;
        }
        return xorValue == 0;
    }
}
