package com.yuren.leetcodecnlearn;

import com.yuren.leetcodecnlearn.entity.ListNode;

import java.util.HashSet;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-06-25 23:11
 */
public class Q817 {
    public int numComponents(ListNode head, int[] G) {
        HashSet<Integer> set = new HashSet<>();
        for (int x : G) {
            set.add(x);
        }
        ListNode cur = head;
        int res = 0;
        while (cur != null) {
            if (set.contains(cur.val) && (cur.next == null || !set.contains(cur.next.val))) {
                res++;
            }
            cur = cur.next;
        }
        return res;

    }

}
