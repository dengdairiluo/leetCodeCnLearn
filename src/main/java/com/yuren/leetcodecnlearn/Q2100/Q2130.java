package com.yuren.leetcodecnlearn.Q2100;

import com.yuren.leetcodecnlearn.entity.ListNode;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-23 22:42
 */
public class Q2130 {
    // 这里长度n必定是偶数
    public int pairSum(ListNode head) {
        ListNode slow = head, fast = head, pre = null;
        // 因为是偶数，确保faster刚好抵达最后一个节点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            // 直接开始翻转
            ListNode tmp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = tmp;
        }
        int res = Integer.MIN_VALUE;
        // 此时pre是前面翻转后的指针头，而slow则是下一个起点
        while (slow != null) {
            int tmp = slow.val + pre.val;
            if (tmp > res)
                res = tmp;
            pre = pre.next;
            slow = slow.next;
        }
        return res;
    }
}
