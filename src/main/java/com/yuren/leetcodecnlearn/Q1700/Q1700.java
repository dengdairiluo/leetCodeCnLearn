package com.yuren.leetcodecnlearn.Q1700;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-05-20 21:11
 */
public class Q1700 {
    public int countStudents(int[] students, int[] sandwiches) {
        int n = students.length;
        Queue<Integer> queue = new ArrayDeque<>();
        for (int student : students) {
            queue.offer(student);
        }
        int j = 0;//三明治栈顶的元素位置
        int count = 0;//记录吃过三明治的学生数量
        int currSize = -1;
        while (queue.size() != currSize) {
            currSize = queue.size();
            for (int i = 0; i < currSize; i++) {
                int value = queue.remove();
                if (value == sandwiches[j]) {
                    j++;
                    count++;
                } else {
                    queue.offer(value);
                }
            }
        }
        return n - count;
    }
}
