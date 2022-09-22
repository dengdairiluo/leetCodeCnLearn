package com.yuren.leetcodecnlearn;

import com.yuren.leetcodecnlearn.entity.ListNode;

import java.util.Random;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-12-18 22:40
 */
public class Q382 {
    ListNode head;

    public Q382(ListNode head) {
        this.head = head;
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        if (head == null) {
            return -1;
        }
        //获取链表长度
        int len = getLength(head);
        Random random = new Random();
        //随机获取 [0, len - 1] 任意整数值
        int c = random.nextInt(len);
        int val = -1;
        ListNode cur = head;
        //定位到获取的节点位置
        while (c-- >= 0) {
            val = cur.val;
            cur = cur.next;
        }
        return val;
    }

    private int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }

}
