package com.yuren.leetcodecnlearn.Q900;

import java.util.HashMap;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-08-21 23:48
 */
public class Q949 {
    public String largestTimeFromDigits(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int bigerthansix = 0;
        for (int i = 0; i < 4; i++) {
            if (arr[i] >= 6) {
                bigerthansix += 1;
            }
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        StringBuilder str = new StringBuilder();
        int h1 = -1, h2 = -1, m1 = -1, m2 = -1;
        // 寻找小时第一位
        if (bigerthansix >= 2) {
            for (int i = 1; i >= 0; i--) {
                if (map.containsKey(i) && map.get(i) > 0) {
                    h1 = i;
                    map.put(i, map.get(i) - 1);
                    break;
                }
            }
        } else {
            for (int i = 2; i >= 0; i--) {
                if (map.containsKey(i) && map.get(i) > 0) {
                    h1 = i;
                    map.put(i, map.get(i) - 1);
                    break;
                }
            }
        }
        if (h1 == -1) {
            return "";
        } else {
            str.append(h1);
        }

        // 寻找小时第二位
        if (h1 == 0 || h1 == 1) {
            for (int i = 9; i >= 0; i--) {
                if (map.containsKey(i) && map.get(i) > 0) {
                    h2 = i;
                    map.put(i, map.get(i) - 1);
                    break;
                }
            }
        } else {
            for (int i = 3; i >= 0; i--) {
                if (map.containsKey(i) && map.get(i) > 0) {
                    h2 = i;
                    map.put(i, map.get(i) - 1);
                    break;
                }
            }
        }
        if (h2 == -1) {
            return "";
        } else {
            str.append(h2);
        }
        str.append(':');

        // 寻找分钟第一位
        for (int i = 5; i >= 0; i--) {
            if (map.containsKey(i) && map.get(i) > 0) {
                m1 = i;
                map.put(i, map.get(i) - 1);
                break;
            }
        }
        if (m1 == -1) {
            return "";
        } else {
            str.append(m1);
        }

        //寻找分钟第二位
        for (int i = 9; i >= 0; i--) {
            if (map.containsKey(i) && map.get(i) > 0) {
                m2 = i;
                map.put(i, map.get(i) - 1);
                break;
            }
        }
        if (m2 == -1) {
            return "";
        } else {
            str.append(m2);
        }

        return str.toString();
    }
}
