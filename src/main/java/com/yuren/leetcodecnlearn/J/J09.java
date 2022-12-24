package com.yuren.leetcodecnlearn.J;

import java.util.LinkedList;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-05-15 17:41
 */
public class J09 {
    LinkedList<Integer> a;
    LinkedList<Integer> b;

    public J09() {
        a = new LinkedList<>();
        b = new LinkedList<>();
    }

    public void appendTail(int value) {
        a.addLast(value);
    }

    public int deleteHead() {
        if (!b.isEmpty()) {
            return b.removeLast();
        }
        if (a.isEmpty()) {
            return -1;
        }
        while (!a.isEmpty()) {
            b.addLast(a.removeLast());
        }
        return b.removeLast();
    }

}
