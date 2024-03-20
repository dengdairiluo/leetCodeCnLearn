package com.yuren.leetcodecnlearn.Q2300;

import java.util.HashMap;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-03-20 23:25
 */
public class Q2306 {
    public long distinctNames(String[] ideas) {

        //hash分类。key为后缀，value为首字母
        HashMap<String, Integer> hash = new HashMap<>();

        //每两个不同首字母的字符串所出现的相同后缀
        int[][] bad = new int[26][26];

        //各首字母的出现次数
        long[] number = new long[26];

        //循环每一个idea
        for (String s : ideas) {
            int i = s.charAt(0) - 'a';
            s = s.substring(1);
            //将最新数据加入到hash分类中
            int mask = hash.getOrDefault(s, 0);
            hash.put(s, mask | 1 << i);
            //首字母出现次数+1
            number[i]++;

            // 求当前后缀的首字母中存在的首字母[j]与最新加入的首字母[i]的位置，并记录
            // 此证明具有i，j首字母的两个后缀可组合的个数应当减一
            for (int j = 0; j < 26; ++j)
                if ((mask >> j & 1) == 1) {
                    bad[i][j]++;
                    bad[j][i]++;
                }
        }

        //统计两个不同首字母所存在的后缀个数去除其交集不可组合的后缀个数的相乘结果
        long end = 0L;
        for (int i = 0; i < 26; i++)
            for (int j = i + 1; j < 26; j++)
                end += (number[i] - bad[i][j]) * (number[j] - bad[i][j]);

        //因为正反变两倍，所以位运算向左移动一位
        return end << 1;
    }
}
