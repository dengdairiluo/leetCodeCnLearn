package com.yuren.leetcodecnlearn.Q1600;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-06-12 23:31
 */
public class Q1681 {
    private static final int INF = Integer.MAX_VALUE / 2;

    int result = INF;

    public int minimumIncompatibility(int[] nums, int k) {

        Arrays.sort(nums);
        Node[] nodes = new Node[k];

        for (int i = 0; i < k; ++i) {
            nodes[i] = new Node();
        }

        int n = nums.length;
        int bucketSize = n / k;
        dfs(nums, 0, 0, nodes, bucketSize);

        return result == INF ? -1 : result;
    }

    private void dfs(int[] nums, int index, int sum, Node[] nodes, int bucketSize) {
        if (index == nums.length) {
            result = Math.min(result, sum);
            return;
        }
        int currentSize = bucketSize;
        int num = nums[index];
        for (Node node : nodes) {
            if (node.size == currentSize || node.max == num) {
                continue;
            }
            currentSize = node.size;
            int prevMin = node.min;
            int prevMax = node.max;
            if (node.size == 0) {
                node.min = num;
            }
            node.max = num;
            node.size++;
            int diff = -Math.max(0, prevMax - prevMin);
            diff += node.max - node.min;
            if (diff + sum < result) {
                dfs(nums, index + 1, sum + diff, nodes, bucketSize);
            }
            node.min = prevMin;
            node.max = prevMax;
            node.size--;
        }
    }

    private static class Node {
        boolean[] visited;
        int size;
        int min;
        int max;

        Node() {
            visited = new boolean[17];
            min = INF;
            max = 0;
            size = 0;
        }

    }
}
