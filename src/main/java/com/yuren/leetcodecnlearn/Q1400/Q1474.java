package com.yuren.leetcodecnlearn.Q1400;

import com.yuren.leetcodecnlearn.entity.ListNode;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-05-21 20:55
 */
public class Q1474 {
    private int M;
    private int N;

    public ListNode deleteNodes(ListNode head, int m, int n) {
        M = m;
        N = n;
        return delete(head, m, n);
    }

    private ListNode delete(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }

        // 删完 n 个结点，重新设置跳过数 m 和待删数 n
        if (n == 0) {
            n = N;
            m = M;
        } else if (m == 0) { // 已经跳过 m 个结点，删除本节点，并将待删数 n 减少1
            return delete(head.next, m, n - 1);
        }

        // 还没跳完 m 个结点，继续跳
        head.next = delete(head.next, m - 1, n);

        return head;
    }

}
