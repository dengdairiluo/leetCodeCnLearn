package com.yuren.leetcodecnlearn.Q2000;

import com.yuren.leetcodecnlearn.entity.ListNode;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-11-25 22:25
 */
public class Q2074 {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        return reverse(head, 1);
    }

    ListNode reverse(ListNode head, int group) {   //group 为自然递增序列（1，2，3，4，5……）
        if (head == null) {
            return head;
        }
        //慢指针--->指向每个链表头
        ListNode slow = head;
        //快指针--->指向下一个链表头
        ListNode fast = head;
        ListNode middle = head;//当前链表的尾节点
        int count = 0;   //记录当前链表的的节点个数
        for (int i = 0; i < group; i++) {
            if (fast == null) {
                if (count < group && count % 2 != 0) {
                    return slow;
                } else if (count < group && count % 2 == 0) {
                    ListNode newHead = reverseList(slow, fast);
                    slow.next = reverse(fast, group + 1);
                    return newHead;
                }
                return null;
            } else {
                count++;
            }
            if (i < group - 1) {
                middle = middle.next;
            }

            fast = fast.next;
        }
        if (group % 2 != 0) {
            ListNode tmp = reverse(fast, group + 1);
            middle.next = tmp;
            return slow;
        } else {
            ListNode newHead = reverseList(slow, fast);
            slow.next = reverse(fast, group + 1);
            return newHead;
        }

    }

    ListNode reverseList(ListNode head, ListNode fast) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != fast) {
            ListNode nextL = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextL;
        }

        return pre;
    }
}
