package com.yuren.leetcodecnlearn.Q1800;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-08-10 23:55
 */
public class Q1840 {
    public int maxBuilding(int n, int[][] restrictions) {
        int len = restrictions.length;
        if (len == 0) {
            return n - 1;
        }
        Arrays.sort(restrictions, (a, b) -> a[0] - b[0]);
        int lastid = 1, lasth = 0;
        for (int i = 0; i < len; i++) {
            int[] res = restrictions[i];
            int id = res[0], max = res[1];
            restrictions[i][1] = Math.min(max, (id - lastid) + lasth);
            lastid = id;
            lasth = restrictions[i][1];
        }
        lastid = restrictions[len - 1][0];
        lasth = restrictions[len - 1][1];
        for (int i = len - 2; i >= 0; i--) {
            int[] res = restrictions[i];
            int id = res[0], max = res[1];
            restrictions[i][1] = Math.min(max, lasth + lastid - id);
            lastid = id;
            lasth = restrictions[i][1];
        }
        lastid = 1;
        lasth = 0;
        int ans = 0;
        for (int[] res : restrictions) {
            int id = res[0], h = res[1];
            int abs = Math.abs(lasth - h);
            int diff = id - lastid - 1 - abs;
            int cur = Math.max(lasth, h) + (diff >> 1);
            if ((diff & 1) == 1) {
                cur++;
            }
            ans = Math.max(ans, cur);
            lastid = res[0];
            lasth = h;
        }
        ans = Math.max(ans, lasth - lastid + n);
        return ans;
    }
}
