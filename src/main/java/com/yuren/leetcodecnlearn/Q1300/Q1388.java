package com.yuren.leetcodecnlearn.Q1300;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-02-20 00:57
 */
public class Q1388 {
    public int maxSizeSlices(int[] slices) {
        int n = slices.length;
        // 使用数组模拟双向链表
        int[] linkL = new int[n];
        int[] linkR = new int[n];
        for (int i = 0; i < n; ++i) {
            linkL[i] = i == 0 ? n - 1 : i - 1;
            linkR[i] = i == n - 1 ? 0 : i + 1;
        }
        // 将初始的元素放入优先队列中
        boolean[] valid = new boolean[n];
        Arrays.fill(valid, true);
        PriorityQueue<int[]> queue = new PriorityQueue<>((array1, array2) -> {
            if (array1[0] != array2[0]) {
                return array2[0] - array1[0];
            } else {
                return array2[1] - array1[1];
            }
        });
        for (int i = 0; i < n; ++i) {
            queue.offer(new int[]{slices[i], i});
        }

        int ans = 0;
        for (int i = 0; i < n / 3; ++i) {
            // 从优先队列中取出元素时要判断其是否已被删除
            while (!valid[queue.peek()[1]]) {
                queue.poll();
            }
            int pos = queue.poll()[1];
            ans += slices[pos];
            // 更新当前位置的值
            slices[pos] = slices[linkL[pos]] + slices[linkR[pos]] - slices[pos];
            queue.offer(new int[]{slices[pos], pos});
            // 删去左右两侧的值
            valid[linkL[pos]] = valid[linkR[pos]] = false;
            // 修改双向链表
            linkR[linkL[linkL[pos]]] = pos;
            linkL[linkR[linkR[pos]]] = pos;
            linkL[pos] = linkL[linkL[pos]];
            linkR[pos] = linkR[linkR[pos]];
        }
        return ans;
    }
}
