package com.yuren.leetcodecnlearn.Q100;

import com.yuren.leetcodecnlearn.entity.ListNode;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-09-26 22:29
 */
public class Q143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        //找中点，链表分成两个
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = slow.next;
        slow.next = null;

        //第二个链表倒置
        newHead = reverseList(newHead);

        //链表节点依次连接
        while (newHead != null) {
            ListNode temp = newHead.next;
            newHead.next = head.next;
            head.next = newHead;
            head = newHead.next;
            newHead = temp;
        }

    }

    private ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode tail = head;
        head = head.next;

        tail.next = null;

        while (head != null) {
            ListNode temp = head.next;
            head.next = tail;
            tail = head;
            head = temp;
        }

        return tail;
    }

}
