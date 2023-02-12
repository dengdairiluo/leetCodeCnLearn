package com.yuren.leetcodecnlearn.Q1400;

import com.yuren.leetcodecnlearn.entity.ListNode;
import com.yuren.leetcodecnlearn.entity.TreeNode;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-02-12 23:44
 */
public class Q1367 {
    /**
     * 树上KMP
     *
     * @param head
     * @param root
     * @return
     */
    private boolean isSubPath(ListNode head, TreeNode root) {

        ListNode cur = head;
        int size = 0;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        int[] arr = new int[size];
        size = 0;
        cur = head;
        while (cur != null) {
            arr[size++] = cur.val;
            cur = cur.next;
        }
        int[] next = getNextArray(arr);
        return process(root, arr, next, 0);
    }


    private boolean process(TreeNode node, int[] arr, int[] next, int len) {

        if (len == next.length) {
            return true;
        }

        if (node == null) {
            return false;
        }
        int val = node.val;

        int tmp = len;
        while (tmp != 0 && val != arr[tmp]) {
            tmp = next[tmp];
        }
        int nextLen = val == arr[tmp] ? tmp + 1 : 0;
        return process(node.left, arr, next, nextLen) || process(node.right, arr, next, nextLen);
    }

    /**
     * 返回一个数组  数组中 i 位置的值表示  从0...i-1 的位置，前缀和后缀相等的最长位置，这个位置最长为 i-2
     * 例如
     * chars 为  a  b  a  b  c  a  b  a  c
     * next  为  -1 0  0  1  2  0  1  2  3
     */
    private int[] getNextArray(int[] arr) {
        if (arr.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[arr.length];

        //0 和 1位置的值写死的
        next[0] = -1;
        next[1] = 0;

        // i 表示 chars中来到的位置，要计算它在next中同样位置的值
        int i = 2;
        // 既表示 i 这个位置的值，也就是前后缀长度
        // 也表示如果没有匹配上，也表示 i-1 要和 len位置的字符进行比较
        // 例如，nest[17] = 5， 5既表示 0..16中前后缀的长度为5，也表示 计算 next[18]的时候，要用 chars[17] 和 next[5]的值进行比较
        int len = 0;
        while (i < arr.length) {
            // 如果匹配，i往前移动
            // len+1；
            if (arr[i - 1] == arr[len]) {
                next[i++] = ++len;
            }
            // 如果没匹配，len没有来到开始位置,接着往前跳
            else if (len > 0) {
                len = next[len];
            }
            // len 已经来到开始位置都没匹配，为0
            else {
                next[i++] = 0;
            }
        }
        return next;
    }
}
