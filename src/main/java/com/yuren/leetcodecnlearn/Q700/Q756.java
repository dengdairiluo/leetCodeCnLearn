package com.yuren.leetcodecnlearn.Q700;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-05-31 07:13
 */
public class Q756 {
    Set<Integer> appeared;
    int[][] T;

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        T = new int[7][7];
        int n = bottom.length();
        int[][] A = new int[n][n];
        appeared = new HashSet<>();
        for (int i = 0; i < n; i++) {
            A[n - 1][i] = bottom.charAt(i) - 'A';
        }
        for (String all : allowed) {
            T[all.charAt(0) - 'A'][all.charAt(1) - 'A'] |= 1 << (all.charAt(2) - 'A');
        }
        return dfs(A, 0, n - 1, 0);
    }

    public boolean dfs(int[][] A, int R, int N, int i) {//长为N，编号为R的行
        if (N == 1 && i == 1) {
            return true;
        } else if (i == N) {
            if (appeared.contains(R)) {//下面一行不一样，但这行一样的，这说明这一行这样搭不能构成金字塔，就放弃了
                return false;
            }
            appeared.add(R);//搭好了这行，才能往上搭
            return dfs(A, 0, N - 1, 0);
        } else {
            int w = T[A[N][i]][A[N][i + 1]];
            for (int b = 0; b < 7; b++) {
                if (((w >> b) & 1) != 0) {
                    A[N - 1][i] = b;
                    if (dfs(A, R * 8 + b + 1, N, i + 1)) {//给这行这种组合编号为R*8+b+1
                        return true;
                    }
                }
            }
            return false;
        }

    }
}
