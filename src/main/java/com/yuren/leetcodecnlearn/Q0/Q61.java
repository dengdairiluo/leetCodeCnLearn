package com.yuren.leetcodecnlearn.Q0;

import com.yuren.leetcodecnlearn.entity.ListNode;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-08-29 21:57
 */
public class Q61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode head2 = new ListNode(0, head);
        int count = 0;
        while (head2.next != null) {
            head2 = head2.next;
            ++count; // 求出链表长度
        }
        head2.next = head;
        k %= count;
        // 为的是找到倒数第n个结点
        k = count - k;
        while (k > 0) {
            head2 = head2.next;
            head = head.next;
            k--;
        }
        head2.next = null;
        return head;
    }


}
