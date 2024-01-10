package com.yuren.leetcodecnlearn.Q2100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-01-10 23:20
 */
public class Q2166 {
    byte[] bytes0;
    byte[] bytes1;
    int num1 = 0;
    int s;

    public Q2166(int size) {
        bytes0 = new byte[size];
        bytes1 = new byte[size];
        for (int i = 0; i < size; i++) {
            bytes0[i] = 1;
        }
        s = size;
    }

    public void fix(int idx) {
        if (bytes0[idx] == 1) {
            bytes0[idx] = 0;
            bytes1[idx] = 1;
            num1++;
        }
    }

    public void unfix(int idx) {
        if (bytes1[idx] == 1) {
            bytes1[idx] = 0;
            bytes0[idx] = 1;
            num1--;
        }
    }

    public void flip() {
        byte[] temp = bytes1;
        bytes1 = bytes0;
        bytes0 = temp;
        num1 = s - num1;
    }

    public boolean all() {
        return num1 == s;
    }

    public boolean one() {
        return num1 != 0;
    }

    public int count() {
        return num1;
    }

    public String toString() {
        char[] digits = new char[s];
        for (int i = 0; i < s; i++) {
            digits[i] = bytes1[i] == 0 ? '0' : '1';
        }
        return new String(digits);
    }
}
