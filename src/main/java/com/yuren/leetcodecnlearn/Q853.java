package com.yuren.leetcodecnlearn;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-07-11 23:32
 */
public class Q853 {
    public int carFleet(int target, int[] position, int[] speed) {
        if (position == null || position.length == 0) return 0;
        //由于每辆车的起点不通，故可通过起点左边作为index来记录每一辆车
        int[] temp = new int[target];
        for (int i = 0; i < position.length; i++) {
            temp[position[i]] = speed[i];
        }

        //用于保存每一辆车到终点的时间
        double[] time = new double[position.length];
        //排序位置，以便于从离终点最近的车开始可能形成的车队
        Arrays.sort(position);
        for (int i = 0; i < time.length; i++) {
            int n = position.length - 1 - i;
            //time的顺序为离终点最近的车依次排序
            time[i] = (target - position[n]) / (1.0 * temp[position[n]]);
        }

        int ans = 1;
        for (int i = 0; i < time.length - 1; i++) {
            if (time[i] >= time[i + 1]) {
                //如果后面的车比前面的车按速度算先到终点，那么组成一个车队，时间与前面的车保持一致
                time[i + 1] = time[i];
            } else {
                ans++;
            }
        }
        return ans;
    }
}
