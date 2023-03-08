package com.yuren.leetcodecnlearn.Q1200;

import com.yuren.leetcodecnlearn.entity.ListNode;

public class Q1290 {

    public static int getDecimalValue(ListNode head) {
        int ans = 0;

        while (head != null) {
            ans = (ans << 1) + head.val;
            head = head.next;
        }
        return ans;
    }


}
