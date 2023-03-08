package com.yuren.leetcodecnlearn.Q1100;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-11-26 23:42
 */
public class Q1172 {
    /**
     * 因为最大index为100000，所以100000之后的数都可以只用一个栈存储
     */
    private static final int N = 100010;
    /**
     * 对每个栈计数
     */
    int[] cnt = new int[N];
    /**
     * 用数组和size索引维护每个栈
     */
    Deque<Integer>[] stacks = new ArrayDeque[N];
    /**
     * 用堆保存除了索引为size的栈以外每个不满栈的索引
     */
    PriorityQueue<Integer> q = new PriorityQueue<>();
    int max, size;

    public Q1172(int capacity) {
        this.max = capacity;
        this.size = 0;
    }

    public void push(int val) {
        if (!q.isEmpty()) {
            //循环如果当前size的计数为空，则-1，知道所有栈为空，或者出现第一个不为空的栈
            while (cnt[size] == 0 && size > 0) {
                size--;
            }
            if (q.peek() >= size) {
                //如果堆中的索引大于等于size，则将索引移出
                while (!q.isEmpty() && q.peek() > size) {
                    q.poll();
                }
                //将元素入栈
                stacks[size].push(val);
                cnt[size]++;
            } else {
                //弹出堆中第一个栈索引，并将当前值加入到该栈中
                int cur = q.peek();
                cnt[cur]++;
                stacks[cur].push(val);
                if (cnt[cur] == max) {
                    q.poll();
                }
            }

        } else {
            //因为题目最大index为100000，所以之后的的数据全放一个栈里面
            //如果当前栈等于最大容量，则将栈数组size + 1
            if (cnt[size] == max && size <= 100000) {
                size++;
            }
            //创建新的栈，并将新的值入栈
            if (cnt[size] == 0) {
                stacks[size] = new ArrayDeque<>();
            }
            stacks[size].push(val);
            cnt[size]++;
        }
    }

    public int pop() {
        //如果所有栈为空，则返回-1
        if (size == 0 && cnt[size] == 0) {
            return -1;
        }
        while (cnt[size] == 0 && size > 0) {
            size--;
        }
        int ans = stacks[size].pop();
        cnt[size]--;
        return ans;
    }

    public int popAtStack(int index) {
        if (cnt[index] == 0) {
            return -1;
        }
        int ans = stacks[index].pop();
        //用堆来维护每个不等于最大容量的栈
        if (cnt[index] == max) {
            q.offer(index);
        }
        cnt[index]--;
        return ans;
    }
}
