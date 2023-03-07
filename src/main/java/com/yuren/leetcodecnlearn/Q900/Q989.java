package com.yuren.leetcodecnlearn.Q900;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-09-10 23:56
 */
public class Q989 {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int n = num.length;
        LinkedList<Integer> res = new LinkedList<>();
        int sum = 0;
        int carry = 0;
        // 循环条件：两个数有一个没完
        for (int i = n - 1; i >= 0 || k != 0; k = k / 10, i--) {
            int x = i >= 0 ? num[i] : 0;
            int y = k != 0 ? k % 10 : 0;

            sum = x + y + carry;
            carry = sum / 10;
            res.addFirst(sum % 10);
        }
        if (carry != 0) {
            res.add(0, carry);
        }
        return res;
    }
}
