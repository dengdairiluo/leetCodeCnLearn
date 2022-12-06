package com.yuren.leetcodecnlearn.Q200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-10-03 23:27
 */
public class Q165 {
    public int compareVersion(String version1, String version2) {
        String[] ss1 = version1.split("\\."), ss2 = version2.split("\\.");
        int n = ss1.length, m = ss2.length;
        int i = 0, j = 0;
        while (i < n || j < m) {
            int a = 0, b = 0;
            if (i < n) a = Integer.parseInt(ss1[i++]);
            if (j < m) b = Integer.parseInt(ss2[j++]);
            if (a != b) return a > b ? 1 : -1;
        }
        return 0;
    }
}
