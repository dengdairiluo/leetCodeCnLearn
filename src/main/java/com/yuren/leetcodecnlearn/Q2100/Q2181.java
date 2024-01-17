package com.yuren.leetcodecnlearn.Q2100;

import com.yuren.leetcodecnlearn.entity.ListNode;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-01-17 23:20
 */
public class Q2181 {
    public ListNode mergeNodes(ListNode head) {
        ListNode p = new ListNode();
        ListNode k = p;
        int count = 0;
        head = head.next;
        while (head != null) {
            if (head.val == 0) {
                k.next = new ListNode(count);
                k = k.next;
                count = 0;
            } else {
                count += head.val;
            }
            head = head.next;
        }
        return p.next;
    }
}
