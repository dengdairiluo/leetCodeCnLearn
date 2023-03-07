package com.yuren.leetcodecnlearn.Q1000;

import java.util.PriorityQueue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-10-02 23:51
 */
public class Q1046 {
    public int lastStoneWeight(int[] stones) {
        //因为大的要先出来 排序规则更改
        PriorityQueue<Integer> que = new PriorityQueue<>((a, b) -> b - a);
        for (int i : stones) {
            que.offer(i);
        }
        while (!que.isEmpty()) {
            Integer a = que.poll();
            Integer b = que.poll();
            //循环的条件是不为空，但是第二次取可能是空的，因为此时符合只剩一个的情况。直接返回剩下的一个
            if (b == null) {
                return a;
            }
            que.offer(a - b);
        }
        return 0;
    }
}
