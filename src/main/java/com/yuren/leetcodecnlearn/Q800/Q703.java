package com.yuren.leetcodecnlearn.Q800;

import java.util.PriorityQueue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-05-06 06:50
 */
public class Q703 {
    PriorityQueue<Integer> que;
    private int k;

    public Q703(int k, int[] nums) {
        que = new PriorityQueue<>();
        this.k = k;
        for (int i : nums) {
            add(i);
        }
    }

    public int add(int val) {
        if (que.size() < k) {
            que.offer(val);
        } else if (que.peek() < val) {
            que.poll();
            que.offer(val);
        }
        return que.peek();
    }
}
