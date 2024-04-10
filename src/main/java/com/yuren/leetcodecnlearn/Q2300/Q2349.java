package com.yuren.leetcodecnlearn.Q2300;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-04-10 下午11:25
 */
public class Q2349 {
    Map<Integer, Integer> m = new HashMap<>();
    Map<Integer, Queue<Integer>> ms = new HashMap<>();

    public void change(int index, int number) {
        m.put(index, number);
        ms.computeIfAbsent(number, k -> new PriorityQueue<>()).offer(index); // 直接添加新数据，后面 find 再删除旧的
    }

    public int find(int number) {
        Queue<Integer> q = ms.get(number);
        if (q == null) return -1;
        while (!q.isEmpty() && m.get(q.peek()) != number) q.poll();
        return q.isEmpty() ? -1 : q.peek();
    }
}
