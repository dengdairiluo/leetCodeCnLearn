package com.yuren.leetcodecnlearn;

import com.yuren.leetcodecnlearn.entity.ListNode;

import java.util.Stack;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-12-12 23:18
 */
public class Q369 {
    public ListNode plusOne(ListNode head) {
        Stack<Integer> st = new Stack<>();
        while (head != null) {
            st.push(head.val);
            head = head.next;
        }
        int carry = 0;
        ListNode dummy = new ListNode(0);
        int adder = 1;
        while (!st.empty() || adder != 0 || carry > 0) {
            int digit = st.empty() ? 0 : st.pop();
            int sum = digit + adder + carry;
            carry = sum >= 10 ? 1 : 0;
            sum = sum >= 10 ? sum - 10 : sum;
            ListNode cur = new ListNode(sum);
            cur.next = dummy.next;
            dummy.next = cur;
            adder = 0;
        }
        return dummy.next;
    }

}
