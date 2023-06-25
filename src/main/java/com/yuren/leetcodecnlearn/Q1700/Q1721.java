package com.yuren.leetcodecnlearn.Q1700;

import com.yuren.leetcodecnlearn.entity.ListNode;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-06-26 06:51
 */
public class Q1721 {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        ListNode lkp = dummy, rkp = dummy, fast = head;
        dummy.next = head;
        for (int i = 1; i < k; i++) {
            lkp = lkp.next;
            fast = fast.next;
        }
        fast = fast.next;
        while (fast != null) {
            rkp = rkp.next;
            fast = fast.next;
        }
        ListNode p = lkp.next, q = rkp.next, tmp = p.next;
        if (p.next == q) {
            p.next = q.next;
            lkp.next = q;
            q.next = p;
        } else if (q.next == p) {
            q.next = p.next;
            rkp.next = p;
            p.next = q;
        } else {
            p.next = q.next;
            q.next = tmp;
            lkp.next = q;
            rkp.next = p;
        }
        return dummy.next;
    }
}
