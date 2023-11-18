package com.yuren.leetcodecnlearn.Q2000;

import com.yuren.leetcodecnlearn.entity.ListNode;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-11-18 23:43
 */
public class Q2058 {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int lastIndex = -1;
        int firstIndex = -1;
        int min = -1;
        int max = -1;
        ListNode last = head;
        head = head.next;
        int index = 1;
        while (head.next != null) {
            if (head.val > last.val && head.val > head.next.val || head.val < last.val && head.val < head.next.val) {
                if (firstIndex == -1) {
                    firstIndex = index;
                } else {
                    max = index - firstIndex;
                }
                if (lastIndex != -1) {
                    if (min == -1) {
                        min = index - lastIndex;
                    } else {
                        min = Math.min(min, index - lastIndex);
                    }
                }
                lastIndex = index;
            }
            last = head;
            head = head.next;
            index++;
        }
        return new int[]{min, max};
    }
}
