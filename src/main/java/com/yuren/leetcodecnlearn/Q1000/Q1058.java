package com.yuren.leetcodecnlearn.Q1000;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-10-07 23:48
 */
public class Q1058 {
    public String minimizeError(String[] prices, int target) {
        List<Integer> list = new ArrayList<>();
        for (String str : prices) {
            String[] spli = str.split("\\.");
            target -= Integer.parseInt(spli[0]);
            int last = Integer.parseInt(spli[1]);
            if (last > 0) {
                list.add(last);
            }
        }
        list.sort(Comparator.comparingInt(i2 -> i2));
        int res = 0;
        int i = list.size() - 1;
        for (; i >= 0 && target > 0; i--, target--) {
            res += (1000 - list.get(i));
        }
        if (target != 0) {
            return "-1";
        }
        for (; i >= 0; i--) {
            res += list.get(i);
        }
        // 转字符串
        if (res == 0) {
            return "0.000";
        }
        String str = String.valueOf(res);
        char[] cs = new char[str.length() + 1];
        for (int j = str.length() - 1, index = str.length(); j >= 0; j--) {
            if (str.length() - index == 3) {
                cs[index--] = '.';
            }
            cs[index--] = str.charAt(j);
        }
        return new String(cs);
    }
}
