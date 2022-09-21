package com.yuren.leetcodecnlearn;

import com.yuren.leetcodecnlearn.entity.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-09-21 23:37
 */
public class Q1019 {
    public int[] nextLargerNodes(ListNode head) {
        ListNode tail = reverse(head);
        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[tail.val];
        int index = tail.val - 1;
        tail = tail.next;
        while (index >= 0) {
            while (!stack.isEmpty() && tail.val >= stack.peek()) {
                stack.poll();
            }
            res[index--] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(tail.val);
            tail = tail.next;
        }
        return res;
    }

    private ListNode reverse(ListNode head) {
        //之所以返回dummy是为了用dummy.val保存链表的长度
        ListNode dummy = new ListNode(-1);
        int count = 0;
        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
            count++;
        }
        dummy.val = count;
        dummy.next = pre;
        return dummy;
    }
}
