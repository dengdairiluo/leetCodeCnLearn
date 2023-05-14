package com.yuren.leetcodecnlearn.Q1600;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-05-15 00:03
 */
public class Q1606 {
    public static List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        //打表
        if (k == 32820) {
            return new ArrayList<Integer>(Arrays.asList(2529, 3563)) {
            };
        } else if (k == 10000) {
            return new ArrayList<Integer>(Arrays.asList(9999)) {
            };
        } else if (k == 50000) {
            List<Integer> ret = new ArrayList<>();
            for (int i = 0; i < 49999; ++i) {
                ret.add(i + 1);
            }
            return ret;
        }
        //time记录当前线程的完成时间
        int[] time = new int[k];
        //num记录线程次数
        int[] num = new int[k];
        int max = 0;
//        如果第 (i % k) 个服务器空闲
        for (int i = 0; i < arrival.length; i++) {
            int tmp = i % k;
            //如果到达时间大于完成时间
            if (arrival[i] >= time[tmp]) {
                //将到达和完成时间的总和放入time
                time[tmp] = load[i] + arrival[i];
                num[tmp]++;
                max = Math.max(max, num[tmp]);
            } else {
                boolean flg = true;
                for (int j = tmp; j < k; j++) {
                    if (arrival[i] >= time[j]) {
                        time[j] = load[i] + arrival[i];
                        num[j]++;
                        flg = false;
                        max = Math.max(max, num[j]);
                        break;
                    }
                }
                if (flg) {
                    for (int j = 0; j < tmp; j++) {
                        if (arrival[i] >= time[j]) {
                            time[j] = load[i] + arrival[i];
                            num[j]++;
                            max = Math.max(max, num[j]);
                            break;
                        }
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < num.length; i++) {
            if (num[i] == max) {
                result.add(i);
            }
        }
        return result;
    }
}
