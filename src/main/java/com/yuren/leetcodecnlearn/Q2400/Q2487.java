package com.yuren.leetcodecnlearn.Q2400;

import com.yuren.leetcodecnlearn.entity.ListNode;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-06-19 下午11:34
 */
public class Q2487 {
    public ListNode removeNodes(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode node = removeNodes(head.next); // 返回的链表头一定是最大的
        if (node.val > head.val) {
            return node; // 删除 head
        }
        head.next = node; // 不删除 head
        return head;
    }
}
