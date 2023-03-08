package com.yuren.leetcodecnlearn.Q1100;

import java.util.Stack;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-11-05 20:54
 */
public class Q1130 {
    public int mctFromLeafValues(int[] arr) {
        Stack<Integer> st = new Stack<>();
        st.push(Integer.MAX_VALUE);
        int mct = 0;
        for (int j : arr) {
            while (j >= st.peek()) {
                mct += st.pop() * Math.min(st.peek(), j);
            }
            st.push(j);
        }
        while (st.size() > 2) {
            mct += st.pop() * st.peek();
        }
        return mct;
    }
}
