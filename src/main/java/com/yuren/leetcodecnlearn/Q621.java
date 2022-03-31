package com.yuren.leetcodecnlearn;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-03-31 23:56
 */
public class Q621 {
    public int leastInterval(char[] tasks, int n) {
        //模拟  参考结题@蓝色北半球的图解
        int len = tasks.length;
        int[] cnt = new int[26];
        for (int i = 0; i < len; i++) {
            cnt[tasks[i] - 'A']++;
        }
        //统计哪个字符次数最多
        int maxTypes = 0;
        //统计出现次数为maxTypes的有多少个
        int maxCount = 0;
        Arrays.sort(cnt);
        maxTypes = cnt[25];
        for (int i = 25; i >= 0; i--) {
            if (cnt[i] == maxTypes) {
                maxCount++;
            } else {
                break;
            }
        }
        return Math.max((maxTypes - 1) * (n + 1) + maxCount, len);
    }
}
