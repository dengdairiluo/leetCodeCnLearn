package com.yuren.leetcodecnlearn;

import com.yuren.leetcodecnlearn.entity.ListNode;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-03-31 23:04
 */
public class Q1669 {
    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode p = list1;
        ListNode begin = null;
        ListNode end = null;
        int count = 0;

        while (p != null) {

            if (count == a - 1) {

                //为要删除的节点的前一个节点
                begin = p;
            } else if (count == b) {

                end = p;
                break;
            }
            p = p.next;
            count++;
        }

        begin.next = list2;
        ListNode q = list2;
        while (q.next != null) {

            q = q.next;
        }
        q.next = end.next;
        return list1;

    }


}
