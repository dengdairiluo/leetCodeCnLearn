package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-03-05 22:44
 */
public class Q555 {
    public String splitLoopedString(String[] strs) {
        int[][] maxList = new int[1000][];
        int max = 0;
        int index = 0;
        int strLen = strs.length;
        int[] lens = new int[strLen];
        int lensTmp = 0;
        StringBuilder all = new StringBuilder();
        for (int i = 0; i != strLen; ++i) {
            String str = strs[i];
            String rev = new StringBuilder(str).reverse().toString();
            lensTmp += rev.length();
            lens[i] = lensTmp;
            if (rev.compareTo(str) > 0) {
                strs[i] = rev;
            }
            all.append(strs[i]);
            for (int j = 0; j < strs[i].length(); j++) {
                char c = strs[i].charAt(j);
                if (c == max) {
                    maxList[index++] = new int[]{i, j};
                } else if (c > max) {
                    index = 0;
                    maxList[index++] = new int[]{i, j};
                    max = c;
                }
            }
        }
        if (strLen == 1) {
            return strs[0];
        }
        String ans = "";
        for (int a = 0; a < index; a++) {
            int i = maxList[a][0];
            int j = maxList[a][1];
            StringBuilder cur = new StringBuilder(strs[i]);
            StringBuilder curAnsPre = new StringBuilder();
            StringBuilder curAnsSuf = new StringBuilder();
            StringBuilder others = new StringBuilder();
            if (i != strLen - 1) {
                others.append(all.substring(lens[i]));
            }
            if (i != 0) {
                others.append(all.substring(0, lens[i - 1]));
            }
            curAnsPre.append(cur.substring(j)).append(others).append(cur.substring(0, j));
            cur.reverse();
            j = cur.length() - j - 1;
            curAnsSuf.append(cur.substring(j)).append(others).append(cur.substring(0, j));
            String curStrPre = curAnsPre.toString();
            if (curStrPre.compareTo(ans) > 0) {
                ans = curStrPre;
            }
            String curStrSuf = curAnsSuf.toString();
            if (curStrSuf.compareTo(ans) > 0) {
                ans = curStrSuf;
            }
        }
        return ans;
    }
}
