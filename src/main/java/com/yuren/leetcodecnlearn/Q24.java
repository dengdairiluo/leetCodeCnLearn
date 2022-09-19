package com.yuren.leetcodecnlearn;

import com.yuren.leetcodecnlearn.entity.ListNode;

public class Q24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }


}
