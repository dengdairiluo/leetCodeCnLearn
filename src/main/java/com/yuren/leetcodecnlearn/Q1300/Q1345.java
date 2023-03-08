package com.yuren.leetcodecnlearn.Q1300;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-02-02 23:52
 */
public class Q1345 {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n < 2) {
            return 0;
        }
        // 记录相同值的元素有哪些下标
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], v -> new ArrayList<>()).add(i);
        }
        // BFS使用的队列
        Queue<Integer> queue = new LinkedList<>();
        // 记录已经访问过的元素
        // 数组范围：1 <= arr.length <= 5 * 10^4
        // 使用数组比Set效率更优
        // 使用位图更优
        boolean[] visited = new boolean[n];
        queue.offer(0);
        visited[0] = true;

        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int index = queue.poll();
                if (index == n - 1) {
                    return ans;
                }
                //相同的直接入列
                if (map.containsKey(arr[index])) {
                    for (Integer integer : map.get(arr[index])) {
                        //不和当前点重合且该点没有到达过
                        if (integer != index && !visited[integer]) {
                            queue.offer(integer);
                            visited[integer] = true;
                        }
                    }
                    // 剪枝：这个元素相连的都处理过了，后面再遍历到再处理肯定都已经访问过了，不如直接移除，可以减少遍历的次数
                    map.remove(arr[index]);
                }
                if (index + 1 <= n - 1 && !visited[index + 1]) {
                    queue.offer(index + 1);
                    visited[index + 1] = true;
                }
                if (index - 1 >= 0 && !visited[index - 1]) {
                    queue.offer(index - 1);
                    visited[index - 1] = true;
                }
            }
            ans++;
        }
        return -1;
    }
}
