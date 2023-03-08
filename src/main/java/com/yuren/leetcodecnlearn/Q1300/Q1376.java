package com.yuren.leetcodecnlearn.Q1300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-02-14 23:51
 */
public class Q1376 {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        // 如果就一个人，就没有消息传递
        if (n == 1) {
            return 0;
        }
        int ans = 0;
        int[] time = new int[n];
        time[headID] = -1;
        // 遍历进行消息获取
        for (int i = 0; i < n; i++) {
            if (time[i] == 0) {
                time[i] = getTime(manager, informTime, time, i);
            }
            // 更新最长时间
            if (time[i] > ans) {
                ans = time[i];
            }
        }
        return ans;
    }

    private int getTime(int[] manager, int[] informTime, int[] time, int i) {
        // 获取负责人坐标
        int aim = manager[i];
        // 如果是总负责人，就不在意他的时间
        if (time[aim] == -1) {
            return informTime[aim];
        }
        // 如果负责人的时间未获取，则先获取负责人的时间
        if (time[aim] == 0) {
            time[aim] = getTime(manager, informTime, time, aim);
        }
        // 返回负责人时间+负责人传递消息耗时
        return time[aim] + informTime[aim];
    }
}
