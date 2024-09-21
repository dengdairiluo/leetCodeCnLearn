package com.yuren.leetcodecnlearn.Q2600;

import com.yuren.leetcodecnlearn.entity.ListNode;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-09-22 03:49
 */
public class Q2674 {
    public ListNode[] splitCircularLinkedList(ListNode list) {
        int n = 1;
        ListNode head1 = list;
        ListNode tail2 = null;
        ListNode temp = head1.next;
        while (temp != head1) {
            n++;
            if (temp.next == head1) {
                tail2 = temp;
            }
            temp = temp.next;
        }
        int middleCount = (n + 1) / 2;
        ListNode tail1 = head1;
        for (int i = 1; i < middleCount; i++) {
            tail1 = tail1.next;
        }
        ListNode head2 = tail1.next;
        tail1.next = head1;
        tail2.next = head2;
        return new ListNode[]{head1, head2};
    }
}
