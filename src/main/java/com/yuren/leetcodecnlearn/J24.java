package com.yuren.leetcodecnlearn;

import com.yuren.leetcodecnlearn.entity.ListNode;

public class J24 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
