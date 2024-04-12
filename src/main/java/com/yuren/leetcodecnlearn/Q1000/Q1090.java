package com.yuren.leetcodecnlearn.Q1000;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-10-19 23:25
 */
public class Q1090 {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n = values.length;
        Node[] nodes = new Node[n];
        //封装values和labels
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(values[i], labels[i]);
        }
        //记录子集的分数
        int ans = 0;
        //进行倒序排序
        Arrays.sort(nodes, (o1, o2) -> o2.value - o1.value);
        //使用哈希表记录相同标签出现的次数
        //12ms
        int[] count = new int[20001];
        //16ms
        // Map<Integer,Integer> map = new HashMap<>();
        //注意：子集s的大小小于或等于numWanted，所以有个条件numWanted不等于0
        for (int i = 0; i < n && numWanted != 0; i++) {
            Node node = nodes[i];
            //相同的标签小于useLimit
            if (count[node.label] < useLimit) {
                ans += node.value;
                count[node.label]++;
                numWanted--;
            }
        }
        //返回结果
        return ans;
    }

    private static class Node {
        int value;
        int label;

        public Node(int value, int label) {
            this.value = value;
            this.label = label;
        }
    }
}
