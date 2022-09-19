package com.yuren.leetcodecnlearn;

import com.yuren.leetcodecnlearn.entity.ListNode;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-08-05 23:27
 */
public class J02024 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        //记录上一个节点
        ListNode last = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = last;
            last = head;
            head = temp;
        }
        return last;
    }

}
