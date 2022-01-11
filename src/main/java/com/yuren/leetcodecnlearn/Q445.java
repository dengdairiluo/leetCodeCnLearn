package com.yuren.leetcodecnlearn;

public class Q445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode newHead = new ListNode(0);
        ListNode ptr = newHead;
        while (l1 != null && l2 != null) {
            ptr.val = l1.val + l2.val + ptr.val;
            if (ptr.val > 9) {
                ptr.val -= 10;
                ptr.next = new ListNode(1);
            } else {
                ptr.next = new ListNode(0);
            }
            ptr = ptr.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            ptr.val = ptr.val + l1.val;
            if (ptr.val > 9) {
                ptr.val -= 10;
                ptr.next = new ListNode(1);
            } else {
                ptr.next = new ListNode(0);
            }
            ptr = ptr.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            ptr.val = ptr.val + l2.val;
            if (ptr.val > 9) {
                ptr.val -= 10;
                ptr.next = new ListNode(1);
            } else {
                ptr.next = new ListNode(0);
            }
            ptr = ptr.next;
            l2 = l2.next;
        }
        ListNode res = reverse(newHead);
        return res.val == 0 ? res.next : res;
    }

    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    private ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
