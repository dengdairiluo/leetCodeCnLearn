package com.yuren.leetcodecnlearn;

import java.util.LinkedList;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-05-15 17:41
 */
public class J09 {
    LinkedList<Integer> A, B;

    public J09() {
        A = new LinkedList<>();
        B = new LinkedList<>();
    }

    public void appendTail(int value) {
        A.addLast(value);
    }

    public int deleteHead() {
        if (!B.isEmpty()) {
            return B.removeLast();
        }
        if (A.isEmpty()) {
            return -1;
        }
        while (!A.isEmpty()) {
            B.addLast(A.removeLast());
        }
        return B.removeLast();
    }

}
