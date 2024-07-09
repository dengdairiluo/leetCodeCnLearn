package com.yuren.leetcodecnlearn.Q2500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-07-10 上午12:00
 */
public class Q2526 {
    private int value;
    private int k;
    private int consecCount;

    public Q2526(int value, int k) {
        this.value = value;
        this.k = k;
        this.consecCount = 0;
    }

    public boolean consec(int num) {
        if (num == value) {
            consecCount++;
        } else {
            consecCount = 0;
        }
        return consecCount >= k;
    }

}
