package com.yuren.leetcodecnlearn.Q500;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Q433 {
    private HashSet<String> set;
    private HashSet<String> visit;
    private Queue<String> q;

    public int minMutation(String start, String end, String[] bank) {
        set = new HashSet<>();
        // 基因库中的基因序列加入HashSet
        Collections.addAll(set, bank);
        q = new LinkedList<>();
        visit = new HashSet<>();
        // 先将起点加入队列以及标记为已访问
        q.add(start);
        visit.add(start);
        int step = 0;
        while (!q.isEmpty()) {
            // 需要先得出当前队列的大小
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                // bfs 如果已经变化到了目标序列
                // 返回需要的变化次数 因为变化到目标序列还需要一次 所以+1
                if (bfs(cur, end)) {
                    return step + 1;
                }
            }
            // 这一层没有找到 先加一步再说
            step++;
        }
        // 无法变化到目标序列
        return -1;
    }

    public boolean bfs(String cur, String end) {
        // 四种基因字符
        char[] c = new char[]{'A', 'C', 'G', 'T'};
        char[] str = cur.toCharArray();
        // 当前基因序列的每个位置都有可能发生变化
        for (int i = 0; i < str.length; i++) {
            // 记录当前位置的字符 因为之后需要做修改
            // 修改完之后还需要改回来 避免影响下次判断
            char origin = str[i];
            for (char value : c) {
                // 如果当前字符和变化字符一样 不变是不行的 直接跳出本次循环
                if (origin == value) {
                    continue;
                }
                // 修改一次
                str[i] = value;
                String newStr = new String(str);
                // 是基因库中的基因序列 -即合法
                if (set.contains(newStr)) {
                    // 如果和目标序列一样 直接返回true
                    if (newStr.equals(end)) {
                        return true;
                    }
                    // 没有变化到这个序列过
                    if (!visit.contains(newStr)) {
                        // 加入队列
                        // 标记为已访问！！
                        q.add(newStr);
                        visit.add(newStr);
                    }
                }
            }
            // 将之前可能改了的字符改回来
            str[i] = origin;
        }
        // 没有匹配到目标序列
        return false;
    }
}
