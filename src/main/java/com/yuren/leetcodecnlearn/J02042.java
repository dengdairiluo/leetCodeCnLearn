package com.yuren.leetcodecnlearn;

import java.util.LinkedList;
import java.util.Queue;

public class J02042 {
    Queue<Integer> list;

    public J02042() {//建立队列
        list = new LinkedList<>();
    }

    public int ping(int t) {
        list.add(t);//添加到队列
        while (t - 3000 > list.peek()) {//超过3000差值即队头出列
            list.poll();
        }
        return list.size();//返回大小
    }
}
