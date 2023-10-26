package com.yuren.leetcodecnlearn.Q2000;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-10-26 23:49
 */
public class Q2015 {
    public int[][] averageHeightOfBuildings(int[][] buildings) {
        TreeMap<Integer, int[]> cntHeights = new TreeMap<>();
        List<int[]> list = new ArrayList<>();
        for (int[] building : buildings) {
            cntHeights.putIfAbsent(building[0], new int[2]);
            int[] cntHeight1 = cntHeights.get(building[0]);
            cntHeight1[0] += 1;
            cntHeight1[1] += building[2];

            cntHeights.putIfAbsent(building[1], new int[2]);
            int[] cntHeight2 = cntHeights.get(building[1]);
            cntHeight2[0] -= 1;
            cntHeight2[1] -= building[2];

        }

        int preCnt = 0;
        int preHeight = 0;
        int preKey = -1;
        for (Integer key : cntHeights.keySet()) {
            if (preCnt > 0) {
                int avg = preHeight / preCnt;
                if (!list.isEmpty() && list.get(list.size() - 1)[2] == avg && list.get(list.size() - 1)[1] == preKey) {
                    int[] preitem = list.get(list.size() - 1);
                    preitem[1] = key;
                } else {
                    list.add(new int[]{preKey, key, avg});
                }
            }

            preKey = key;
            preCnt += cntHeights.get(key)[0];
            preHeight += cntHeights.get(key)[1];
        }

        return list.toArray(new int[0][0]);
    }
}
