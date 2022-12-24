package com.yuren.leetcodecnlearn.J;

import java.util.LinkedList;
import java.util.Queue;

public class J02042 {
    Queue<Integer> list;

    public J02042() {//建立队列
        list = new LinkedList<>();
    }

    public int ping(int t) {
        //添加到队列
        list.add(t);
        //超过3000差值即队头出列
        while (t - 3000 > list.peek()) {
            list.poll();
        }
        //返回大小
        return list.size();
    }
}
