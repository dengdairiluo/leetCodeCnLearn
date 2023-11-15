package com.yuren.leetcodecnlearn.Q2000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-11-15 23:54
 */
public class Q2055 {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int len = s.length();
        char[] chars = s.toCharArray();
        //求包含*的前缀和
        int[] sum = new int[len];
        for (int i = 0, num = 0; i < len; i++) {
            if (chars[i] == '*') {
                num++;
            }
            sum[i] = num;
        }
        //获得离每个索引左边最近的'|'
        int[] left = new int[len];
        for (int i = 0, l = -1; i < len; i++) {
            if (chars[i] == '|') {
                l = i;
            }
            left[i] = l;
        }
        //获得离每个索引右边最近的'|'
        int[] right = new int[len];
        for (int i = len - 1, r = -1; i >= 0; i--) {
            if (chars[i] == '|') {
                r = i;
            }
            right[i] = r;
        }
        //初始化返回值
        int size = queries.length;
        int[] ret = new int[size];
        //求每个区间范围内满足条件的*个数
        for (int i = 0; i < size; i++) {
            int x = right[queries[i][0]];
            int y = left[queries[i][1]];
            ret[i] = x == -1 || y == -1 || x == y || x > y ? 0 : sum[y] - sum[x];
        }
        return ret;

    }
}
