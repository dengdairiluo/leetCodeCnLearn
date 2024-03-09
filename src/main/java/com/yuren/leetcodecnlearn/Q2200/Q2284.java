package com.yuren.leetcodecnlearn.Q2200;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-03-09 22:49
 */
public class Q2284 {
    public String largestWordCount(String[] messages, String[] senders) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < senders.length; i++) {
            String sender = senders[i];
            if (!map.containsKey(sender)) {
                map.put(sender, 0);
            }
            Integer n = messages[i].split(" ").length;
            map.put(sender, map.get(sender) + n);
        }
        PriorityQueue<Object[]> queue = new PriorityQueue<>((a, b) -> {
            int a1 = (int) a[1];
            int b1 = (int) b[1];
            if (a1 != b1) {
                return b1 - a1;
            }
            String a0 = a[0].toString();
            String b0 = b[0].toString();
            return b0.compareTo(a0);
        });
        map.forEach((k, v) -> {
            queue.offer(new Object[]{k, v});
        });

        return queue.poll()[0].toString();
    }
}
