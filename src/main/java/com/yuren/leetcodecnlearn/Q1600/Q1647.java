package com.yuren.leetcodecnlearn.Q1600;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-05-30 23:46
 */
public class Q1647 {
    public int minDeletions(String s) {
        int[] a = new int[26];
        char[] cs = s.toCharArray();
        for (char c : cs) {
            // 统计字母个数
            a[c - 'a']++;
        }

        Set<Integer> h = new HashSet<>();
        int res = 0;
        for (int i : a) {
            // 有数目才进行判断
            if (i != 0) {
                // set已经包含就自减
                while (h.contains(i)) {
                    i--;
                    res++;
                }
                // 自减到0时，表示完全删除了某个字母，不能加入set中
                if (i != 0) {
                    h.add(i);
                }
            }
        }
        return res;
    }
}
