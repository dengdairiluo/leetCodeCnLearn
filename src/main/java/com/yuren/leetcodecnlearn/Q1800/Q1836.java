package com.yuren.leetcodecnlearn.Q1800;

import com.yuren.leetcodecnlearn.entity.ListNode;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-08-10 23:51
 */
public class Q1836 {
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        int[] cntMap = new int[100001];
        ListNode temp = head;
        while (temp != null) {
            cntMap[temp.val]++;
            temp = temp.next;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy, node = head;
        while (node != null) {
            if (cntMap[node.val] < 2) {
                prev = node;
                node = node.next;
            } else {
                prev.next = node.next;
                node = node.next;
            }
        }
        return dummy.next;
    }
}
