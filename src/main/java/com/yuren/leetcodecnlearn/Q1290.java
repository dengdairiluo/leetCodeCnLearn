package com.yuren.leetcodecnlearn;

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
