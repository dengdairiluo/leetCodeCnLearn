package com.yuren.leetcodecnlearn;

import com.yuren.leetcodecnlearn.entity.ListNode;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-11-28 23:45
 */
public class Q328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy1 = new ListNode(0, head);
        ListNode dummy2 = new ListNode(0, null);
        ListNode currrnt1 = head;
        ListNode current2 = dummy2;
        while (currrnt1.next != null || current2.next != null) {
            if (current2.next == null) {
                current2.next = currrnt1.next;
                current2 = current2.next;
                currrnt1.next = null;
            } else {
                currrnt1.next = current2.next;
                current2.next = null;
                currrnt1 = currrnt1.next;
            }
        }
        currrnt1.next = dummy2.next;
        return dummy1.next;
    }

}
