package com.yuren.leetcodecnlearn.Q700;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-05-29 23:42
 */
public class Q752 {
    public int openLock(String[] deadends, String target) {
        if ("0000".equals(target)) {
            return 0;
        }

        Set<String> dead = new HashSet<>();
        Collections.addAll(dead, deadends);
        if (dead.contains("0000")) {
            return -1;
        }

        PriorityQueue<AStar> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.f));
        pq.offer(new AStar("0000", target, 0));
        Set<String> seen = new HashSet<>();
        seen.add("0000");

        while (!pq.isEmpty()) {
            AStar node = pq.poll();
            for (String nextStatus : get(node.status)) {
                if (!seen.contains(nextStatus) && !dead.contains(nextStatus)) {
                    if (nextStatus.equals(target)) {
                        return node.g + 1;
                    }
                    pq.offer(new AStar(nextStatus, target, node.g + 1));
                    seen.add(nextStatus);
                }
            }
        }

        return -1;
    }

    public char numPrev(char x) {
        return x == '0' ? '9' : (char) (x - 1);
    }

    public char numSucc(char x) {
        return x == '9' ? '0' : (char) (x + 1);
    }

    // 枚举 status 通过一次旋转得到的数字
    public List<String> get(String status) {
        List<String> ret = new ArrayList<>();
        char[] array = status.toCharArray();
        for (int i = 0; i < 4; ++i) {
            char num = array[i];
            array[i] = numPrev(num);
            ret.add(new String(array));
            array[i] = numSucc(num);
            ret.add(new String(array));
            array[i] = num;
        }
        return ret;
    }

    private static class AStar {
        String status;
        int f, g, h;

        public AStar(String status, String target, int g) {
            this.status = status;
            this.g = g;
            this.h = getH(status, target);
            this.f = this.g + this.h;
        }

        // 计算启发函数
        public static int getH(String status, String target) {
            int ret = 0;
            for (int i = 0; i < 4; ++i) {
                int dist = Math.abs(status.charAt(i) - target.charAt(i));
                ret += Math.min(dist, 10 - dist);
            }
            return ret;
        }
    }

}
