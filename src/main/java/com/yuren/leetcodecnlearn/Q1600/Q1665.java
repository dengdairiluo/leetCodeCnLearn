package com.yuren.leetcodecnlearn.Q1600;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-06-06 23:11
 */
public class Q1665 {
    public int minimumEffort(int[][] tasks) {
        // 确保有 tasks[i][1] >= tasks[i][0], 也就是开启该任务所需要的能量 >= 完成该任务所需要的能量
        // 获取任务的数量
        int n = tasks.length;
        // 特殊情况判断
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            // 只有1个任务
            return tasks[0][1];
        }

        // 对 tasks 按照 tasks[i][1] - tasks[i][0] 降序排序
        Arrays.sort(tasks, (o1, o2) -> {
            // (o2[1] - o2[0]) - (o1[1] - o1[0]) > 0 就交换顺序
            // 也就是 d2 > d1 就交换顺序
            return (o2[1] - o2[0]) - (o1[1] - o1[0]);
        });

        // 完成所有任务的 最少 初始能量, 初始化
        int res = 0;
        for (int[] task : tasks) {
            res += task[0];
        }

        // 创建变量, 记录执行完上一个任务后, 剩余的能量; 初始化
        int remainEnergy = res;
        for (int[] task : tasks) {
            // 判断执行完上一个任务后, 剩余的能量, 能否用来开启当前任务
            if (remainEnergy < task[1]) {
                // 不能开启当前任务, 那么计算需要补充多少能量, 才能开启当前任务
                // 补充时, res 与 remainEnergy 均需要补充
                // 补充能量
                int supplyEnergy = task[1] - remainEnergy;
                res += supplyEnergy;
                remainEnergy += supplyEnergy;
            }
            // 执行当前任务
            remainEnergy -= task[0];
        }
        return res;
    }
}
