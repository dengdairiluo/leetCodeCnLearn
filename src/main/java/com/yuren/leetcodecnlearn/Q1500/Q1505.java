package com.yuren.leetcodecnlearn.Q1500;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-04-03 23:56
 */
public class Q1505 {
    int m;
    int[] tr;

    void add(int x, int val) {
        while (x < m) {
            tr[x] += val;
            x += lowbit(x);
        }
    }

    int query(int x) {
        int ans = 0;
        while (x > 0) {
            ans += tr[x];
            x -= lowbit(x);
        }
        return ans;
    }

    int lowbit(int x) {
        return x & (-x);
    }

    public String minInteger(String num, int k) {
        //我感觉是dfs啊，怎么是树状数组？ 我懂了，保存idx的状态
        //这题和我第一次做树状数组那题有点像啊
        //动态更新每一个的idx
        char[] ch = num.toCharArray();
        int n = num.length();
        if (k >= n * (n - 1) / 2) {
            Arrays.sort(ch);
            return new String(ch);
        }
        //这题是纯纯的树状数组，1409的进阶
        // this.m = n + k + 1;
        this.m = n + 1;
        this.tr = new int[m];
        Deque<Integer>[] qs = new ArrayDeque[10];
        for (int i = 0; i < 10; i++) {
            qs[i] = new ArrayDeque<>();
        }
        for (int i = 1; i <= n; i++) {
            qs[ch[i - 1] - '0'].offer(i);
            add(i, 1);
        }
        int min = n + 1;
        char[] ans = new char[n];
        int idx = 0;
        while (k > 0) {
            boolean flag = true;
            for (int i = 0; i < 10; i++) {
                if (qs[i].isEmpty()) {
                    continue;
                }
                int cur = qs[i].peek();
                //如果为第一个，那么直接跳过，j--
                int pos = query(cur);

                if (k < pos - 1) {
                    continue;
                }
                ans[idx++] = (char) (i + '0');
                flag = false;
                qs[i].poll();
                add(cur, -1);
                pos--;
                k -= pos;
                break;
            }
            if (flag) {
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (!qs[ch[i] - '0'].isEmpty() && qs[ch[i] - '0'].peek() == i + 1) {
                qs[ch[i] - '0'].poll();
                ans[idx++] = ch[i];
            }
        }
        return new String(ans);

    }
}
