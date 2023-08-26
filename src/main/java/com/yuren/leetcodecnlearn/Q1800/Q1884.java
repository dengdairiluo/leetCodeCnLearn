package com.yuren.leetcodecnlearn.Q1800;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-08-26 21:21
 */
public class Q1884 {
    public int twoEggDrop(int n) {
        int sum = 0;
        int index = 0;
        for (int i = 1; sum < n; i++) {
            sum += i;
            index = i;
        }

        return index;
    }
}
