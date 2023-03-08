package com.yuren.leetcodecnlearn.Q1300;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-02-15 23:32
 */
public class Q1377 {

    static final int N = 110, M = N * 2;
    static int[] h = new int[N], ne = new int[M], e = new int[M], q = new int[N];
    boolean[] vis = new boolean[N];
    double[] rate = new double[N];
    int idx, hh, tt = -1;

    public void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public double frogPosition(int n, int[][] edges, int t, int target) {
        if (target == 1) {
            if (n > 1) {
                return 0.0;
            } else {
                return 1.0;
            }
        }

        Arrays.fill(h, -1);
        for (int[] e : edges) {
            int a = e[0], b = e[1];
            add(a, b);
            add(b, a);
        }

        q[++tt] = 1;
        vis[1] = true;
        rate[1] = 1.0;

        int level = 0;
        while (hh <= tt) {
            int sz = tt - hh + 1;
            level++;

            for (int i = 0; i < sz; ++i) {
                int a = q[hh++];
                double rateA = rate[a];
                int cnt = 0;
                //标记父节点，不能往回跳
                vis[a] = true;

                //统计一下 a 有几个孩子
                for (int j = h[a]; j != -1; j = ne[j]) {
                    if (!vis[e[j]]) {
                        cnt++;
                    }
                }
                double rateCur = rateA;
                if (cnt != 0) {
                    rateCur /= cnt;
                }

                for (int j = h[a]; j != -1; j = ne[j]) {
                    int eg = e[j];

                    if (!vis[eg]) {
                        q[++tt] = eg;
                        rate[eg] = rateCur;
                        //到达 tag
                        if (eg == target) {
                            //刚好经过 t 步
                            if (level == t) {
                                return rateCur;
                            //大于 t 步
                            } else if (level > t) {
                                return 0.0;
                            //小于 t 步就已经到达，验证是否存在孩子节点
                            } else {
                                for (int b = h[eg]; b != -1; b = ne[b]) {
                                    if (!vis[e[b]]) {
                                        return 0.0;
                                    }
                                }
                                return rateCur;
                            }
                        }
                    }
                }
            }
        }

        return rate[target];
    }
}
