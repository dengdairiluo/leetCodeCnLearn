package com.yuren.leetcodecnlearn.Q2700;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-10-29 23:56
 */
public class Q2751 {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] id = new Integer[n];
        for (int i = 0; i < n; ++i) id[i] = i;
        Arrays.sort(id, Comparator.comparingInt(i -> positions[i]));

        Deque<Integer> st = new ArrayDeque<>();
        for (int i : id) {
            // 向右，存入栈中
            if (directions.charAt(i) == 'R') {
                st.push(i);
                continue;
            }
            // 向左，与栈中向右的机器人碰撞
            while (!st.isEmpty()) {
                int top = st.peek();
                // 栈顶的健康度大
                if (healths[top] > healths[i]) {
                    healths[top]--;
                    healths[i] = 0;
                    break;
                }
                // 健康度一样大
                if (healths[top] == healths[i]) {
                    healths[st.pop()] = 0;
                    healths[i] = 0;
                    break;
                }
                healths[st.pop()] = 0;
                healths[i]--; // 当前机器人的健康度大
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int h : healths) if (h > 0) ans.add(h);
        return ans;
    }
}
