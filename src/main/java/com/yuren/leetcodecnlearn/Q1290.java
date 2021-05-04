package com.yuren.leetcodecnlearn;

public class Q1290 {

    public static int getDecimalValue(ListNode head) {
        int ans = 0;

        while (head != null) {
            ans = (ans << 1) + head.val;
            head = head.next;
        }
        return ans;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
