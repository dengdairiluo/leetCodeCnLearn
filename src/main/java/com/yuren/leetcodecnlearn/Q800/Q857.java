package com.yuren.leetcodecnlearn.Q800;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-07-13 22:59
 */
public class Q857 {
    private static class Node implements Comparable<Node> {
        int quality, wage;
        double val;

        Node(int quality, int wage) {
            this.quality = quality;
            this.wage = wage;
            this.val = 1.0 * wage / quality;
        }

        @Override
        public int compareTo(Node o) {
            if (this.val < o.val) {
                return 1;
            }
            return -1;
        }
    }

    public double minCostToHireWorkers(int[] quality, int[] wage, int K) {

        //预处理，按工资/质量排序，从大到小
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < quality.length; i++) {
            list.add(new Node(quality[i], wage[i]));
        }
        Collections.sort(list);

        //维护优先队列，质量按从大到小，随时要移除最大的质量
        PriorityQueue<Integer> Q = new PriorityQueue<>((o1, o2) -> o2 - o1);
        double ans = Double.MAX_VALUE;
        double sum = 0;
        for (int i = list.size() - K; i < list.size(); i++) {
            Q.add(list.get(i).quality);
            sum = sum + list.get(i).quality;
        }
        //先计算最后K个员工
        ans = Math.min(ans, sum * list.get(list.size() - K).val);
        //再倒序遍历，取最小值，即可得结果
        for (int i = list.size() - K - 1; i >= 0; i--) {
            int tmp = Q.poll();
            Q.add(list.get(i).quality);
            sum = sum - tmp + list.get(i).quality;
            ans = Math.min(ans, sum * list.get(i).val);
        }
        return ans;
    }
}
