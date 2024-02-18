package com.yuren.leetcodecnlearn.Q2200;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-02-18 23:35
 */
public class Q2244 {
    public int minimumRounds(int[] tasks) {
        // 先从小到大排序，使得相同元素连续分布
        Arrays.sort(tasks);
        // 最少轮数
        int cnt = 0;
        // 上一次的值
        int val = tasks[0];
        // 当前相同元素个数
        int tmpCnt = 0;
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i] == val) {
                // 1、排序后先统计相同元素个数
                tmpCnt++;
            } else {
                if (tmpCnt == 1) {
                    // 只有一个，无法完成任务
                    return -1;
                } else if (tmpCnt == 2) {
                    // 相同元素只有2个，轮数+1
                    cnt++;
                } else {
                    // 2、使用贪心策略，假设每次完成最多的任务数3个
                    int n = tmpCnt % 3;
                    if (n == 0) {
                        // 恰好整除，这样的轮数最少
                        cnt += tmpCnt / 3;
                    } else {
                        // 3、最后两轮组合由3+1变为2+2
                        cnt += (tmpCnt / 3 + 1);
                    }
                }
                // 缓存上一次元素，用于和下一个元素比较
                val = tasks[i];
                // 出现了新元素，计数+1
                tmpCnt = 1;
            }
        }

        // 处理末尾最后一次统计
        if (tmpCnt == 1) {
            return -1;
        } else if (tmpCnt == 2) {
            cnt++;
        } else {
            int n = tmpCnt % 3;
            if (n == 0) {
                cnt += tmpCnt / 3;
            } else {
                cnt += (tmpCnt / 3 + 1);
            }
        }
        return cnt;
    }
}
