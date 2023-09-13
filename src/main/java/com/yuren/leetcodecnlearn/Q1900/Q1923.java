package com.yuren.leetcodecnlearn.Q1900;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-09-13 23:29
 */
public class Q1923 {
    public static final int L_TYPE = 0;
    public static final int S_TYPE = 1;

    public int longestCommonSubpath(int n, int[][] paths) {
        int len = 0;
        int split = n + 1;
        for (int[] path : paths) {
            len += path.length;
            ++len;
        }
        int m = paths.length;
        int[] s = new int[len];
        int sI = 0;
        int[] belongs = new int[len];
        int c = 0;
        int min = paths[0].length;
        for (int[] path : paths) {
            min = Math.min(min, path.length);
            for (int x : path) {
                belongs[sI] = c;
                s[sI++] = x + 1; //修改为1到n
            }
            belongs[sI] = -1;
            ++c;
            s[sI++] = split++;
        }
        s[len - 1] = 0; //修改最后一个分隔符号为0

        //后缀数组计算
        int[] sa = calcSA(s, split);
        int[] rk = calcRk(sa);
        int[] ht = calcHt(sa, rk, s);

        //双指针
        int[] visited = new int[m];
        int visIdx = 1;
        int visCnt = 0;
        int ans = 0;

        //单调队列
        int[] queue = new int[len];
        int qS = 0;
        int qE = -1;
        int l = 0;
        int r = 0;
        int pos = sa[r];
        //queue.addLast(pos);
        visited[belongs[pos]]++;
        visCnt++;

        while (++r < ht.length) {
            int v = ht[r];
            pos = sa[r];
            if (belongs[pos] == -1) {
                break;
            }
            while (qS <= qE && ht[queue[qE]] >= v) {
                --qE;
            }
            //insert
            queue[++qE] = r;
            visited[belongs[pos]]++;
            if (visited[belongs[pos]] == 1) {
                visCnt++;
            }

            while (visCnt == m) {
                //remove l
                pos = sa[l];
                visited[belongs[pos]]--;
                if (visited[belongs[pos]] == 0) {
                    visCnt--;
                    //最后一次visCnt==m的单调队列队头值
                    ans = Math.max(ans, ht[queue[qS]]);
                }
                ++l;
                if (queue[qS] == l) {
                    ++qS;
                }
            }

        }
        return ans;
    }

    //诱导排序
    public static int[] calcSA(String s, int sigma) {
        int n = s.length();
        int[] sArr = new int[n + 1];
        int idx = 0;
        for (char c : s.toCharArray()) {
            sArr[idx++] = c;
        }
        return calcSA(sArr, sigma + 1);
    }

    public static int[] calcSA(int[] s, int sigma) {
        int[] sa = saIS(s, s.length, sigma);
        return Arrays.copyOfRange(sa, 1, sa.length);
    }

    public static int[] calcRk(int[] sa) {
        int[] rk = new int[sa.length];
        for (int i = 0; i < sa.length; i++) {
            rk[sa[i]] = i;
        }
        return rk;
    }

    public static int[] calcHt(String s, int[] sa, int[] rk) {
        //ht[i] = lcp(sa[i], sa[i - 1]) => ht[rk[i]] = lcp(i, sa[rk[i] - 1])
        //ht[rk[i]] >= ht[rk[i - 1]] - 1
        char[] cs = s.toCharArray();
        int[] ts = new int[cs.length];
        for (int i = 0; i < ts.length; i++) {
            ts[i] = cs[i];
        }
        return calcHt(sa, rk, ts);
    }

    private static int[] calcHt(int[] sa, int[] rk, int[] cs) {
        int n = sa.length;
        int[] ht = new int[n];
        ht[0] = 0;
        int k = 0;
        for (int i = 0; i < n; i++) {
            int p = rk[i];
            if (p == 0) {
                continue;
            }
            if (k > 0) {
                --k;
            }
            while (sa[p] + k < n && sa[p - 1] + k < n &&
                    cs[sa[p] + k] == cs[sa[p - 1] + k]) {
                ++k;
            }
            ht[p] = k;
        }
        return ht;
    }

    public static int[] saIS(int[] s, int len, int sigma) {
        int n = len;
        int[] type = new int[n];
        int[] position = new int[n];
        int[] name = new int[n];
        int[] sa = new int[n];

        int bn = sigma + 1;
        int[] bucket = new int[bn];
        int[] lbucket = new int[bucket.length];
        int[] sbucket = new int[bucket.length];

        //桶
        for (int i = 0; i < n; i++) {
            bucket[s[i]]++;
        }
        for (int i = 1; i < bn; i++) {
            bucket[i] += bucket[i - 1];
            lbucket[i] = bucket[i - 1];
            sbucket[i] = bucket[i] - 1;
        }

        //计算后缀类型
        type[n - 1] = S_TYPE;
        for (int i = n - 2; i >= 0; i--) {
            if (s[i] < s[i + 1]) {
                type[i] = S_TYPE;
            } else if (s[i] > s[i + 1]) {
                type[i] = L_TYPE;
            } else {
                type[i] = type[i + 1];
            }
        }

        //寻找每个LMS子串
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            if (isLcmLetter(type, i)) {
                position[cnt++] = i;
            }
        }

        //LMS子串排序
        Arrays.fill(sa, -1);
        for (int i = 0; i < cnt; i++) {
            sa[sbucket[s[position[i]]]--] = position[i];
        }
        induced_sort(s, sa, type, bucket, lbucket, sbucket, n, sigma);

        //为每个LMS子串命名
        Arrays.fill(name, -1);
        int lastIdx = -1;
        int nameCnt = 1; //上一次处理的LMS子串与名称计数
        boolean flag = false;
        for (int i = 1; i < n; i++) {
            int p = sa[i];
            if (isLcmLetter(type, p)) {
                if (lastIdx >= 0 && !equalsLCMStr(s, p, lastIdx, type)) {
                    nameCnt++;
                }
                if (lastIdx >= 0 && nameCnt == name[lastIdx]) {
                    flag = true;
                }
                name[p] = nameCnt;
                lastIdx = p;
            }
        }
        name[n - 1] = 0;

        //生成s1
        int[] s1 = new int[cnt];
        int pos = 0;
        for (int i = 0; i < n; i++) {
            if (name[i] >= 0) {
                s1[pos++] = name[i];
            }
        }

        //计算sa1
        int[] sa1;
        if (!flag) {
            //直接桶计算sa1
            sa1 = new int[cnt + 1];

            for (int i = 0; i < cnt; i++) {
                sa1[s1[i]] = i;
            }
        } else {
            sa1 = saIS(s1, cnt, nameCnt);
        }

        //从sa1诱导到sa
        lbucket[0] = 0;
        sbucket[0] = 0;
        for (int i = 1; i <= sigma; i++) {
            lbucket[i] = bucket[i - 1];
            sbucket[i] = bucket[i] - 1;
        }
        Arrays.fill(sa, -1);
        for (int i = cnt - 1; i >= 0; i--) {
            sa[sbucket[s[position[sa1[i]]]]--] = position[sa1[i]];
        }
        induced_sort(s, sa, type, bucket, lbucket, sbucket, n, sigma);
        return sa;
    }

    private static boolean equalsLCMStr(int[] s, int i, int j, int[] type) {
        do {
            if (s[i] != s[j]) {
                return false;
            }
            i++;
            j++;
        } while (!isLcmLetter(type, i) && !isLcmLetter(type, j));
        return s[i] == s[j] && type[i] == type[j];
    }

    private static void induced_sort(int[] s, int[] sa, int[] type, int[] bucket,
                                     int[] lbucket, int[] sbucket, int n, int sigma) {
        //L
        for (int i = 0; i < n; i++) {
            if (sa[i] > 0 && type[sa[i] - 1] == L_TYPE) {
                sa[lbucket[s[sa[i] - 1]]++] = sa[i] - 1;
            }
        }
        //Reset S
        for (int i = 1; i <= sigma; i++) {
            sbucket[i] = bucket[i] - 1;
        }
        //S
        for (int i = n - 1; i >= 0; i--) {
            if (sa[i] > 0 && type[sa[i] - 1] == S_TYPE) {
                sa[sbucket[s[sa[i] - 1]]--] = sa[i] - 1;
            }
        }
    }

    private static boolean isLcmLetter(int[] type, int i) {
        return i > 0 && type[i] == S_TYPE && type[i - 1] == L_TYPE;
    }
}
