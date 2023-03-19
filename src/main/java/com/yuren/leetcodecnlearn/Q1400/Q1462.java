package com.yuren.leetcodecnlearn.Q1400;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-03-19 23:59
 */
public class Q1462 {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Integer>[] pres = new List[numCourses];
        for (int i = 0; i < pres.length; i++) {
            pres[i] = new ArrayList<>();
        }
        for (int[] prerequisite : prerequisites) {
            pres[prerequisite[1]].add(prerequisite[0]);
        }
        long[][] preCurs = new long[numCourses][];
        for (int i = 0; i < numCourses; i++) {
            calNext(i, pres, preCurs);
        }
        List<Boolean> ans = new ArrayList<>();
        for (int[] query : queries) {
            ans.add(isPre(preCurs, query[1], query[0]));
        }
        return ans;
    }

    private boolean isPre(long[][] preCurs, int curr, int pre) {
        if (pre >= 64) {
            return (preCurs[curr][1] & (1L << (pre - 64))) != 0;
        } else {
            return (preCurs[curr][0] & (1L << pre)) != 0;
        }
    }

    private long[] getIndex(int num) {
        if (num >= 64) {
            return new long[]{0, 1L << (num - 64)};
        } else {
            return new long[]{1L << num, 0};
        }
    }

    private long[] calNext(int num, List<Integer>[] pres, long[][] preCurs) {
        if (preCurs[num] != null) {
            return preCurs[num];
        }
        List<Integer> ps = pres[num];
        long[] result = new long[2];
        for (Integer p : ps) {
            long[] longs = calNext(p, pres, preCurs);
            long[] index = getIndex(p);
            result[0] |= longs[0] | index[0];
            result[1] |= longs[1] | index[1];
        }
        preCurs[num] = result;
        return result;
    }
}
