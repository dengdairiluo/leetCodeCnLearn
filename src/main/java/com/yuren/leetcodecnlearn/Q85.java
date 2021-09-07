package com.yuren.leetcodecnlearn;

import java.util.Deque;
import java.util.LinkedList;

public class Q85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[] now = new int[col];
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '0')
                    now[j] = 0;
                else
                    now[j] += 1;
            }
            result = Integer.max(findMaxRect(now), result);
        }
        return result;
    }

    public int findMaxRect(int[] record) {
        Deque<Integer> stack = new LinkedList<>();
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < record.length; i++) {
            while (!stack.isEmpty() && record[i] < record[stack.peek()]) {
                int nowHeight = record[stack.poll()];
                while (!stack.isEmpty() && record[stack.peek()] == nowHeight)
                    stack.poll();
                int begin = stack.isEmpty() ? -1 : stack.peek();
                int nowWidth = i - begin - 1;
                result = Math.max(result, nowHeight * nowWidth);
            }
            stack.push(i);
        }
        int right = record.length;
        while (!stack.isEmpty()) {
            int nowHeight = stack.poll();
            while (!stack.isEmpty() && record[stack.peek()] == record[nowHeight])
                stack.poll();
            int left = stack.isEmpty() ? -1 : stack.peek();
            int nowWidth = right - left - 1;
            result = Math.max(result, nowWidth * record[nowHeight]);
        }
        return result;
    }
}
