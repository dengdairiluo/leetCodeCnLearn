package com.yuren.leetcodecnlearn.Q1600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-06-03 23:43
 */
public class Q1654 {
    boolean[] forwardVisited;
    boolean[] backwardVisited;
    boolean[] forbiddenVisited;
    int a, b, x;

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        if (x == 0) {
            return 0;
        }
        this.a = a;
        this.b = b;
        this.x = x;
        forwardVisited = new boolean[2000 + a + b + 1];
        backwardVisited = new boolean[2000 + a + b + 1];
        forbiddenVisited = new boolean[2000 + a + b + 1];
        for (int pos : forbidden) {
            forbiddenVisited[pos] = true;
        }
        return dfs(a, 0, false);

    }

    int dfs(int cur, int steps, boolean isBackward) {
        if (cur < 0 || cur > 2000 + b + a) {
            return -1;
        }

        if (forbiddenVisited[cur] || forwardVisited[cur] || (isBackward && backwardVisited[cur])) {
            return -1;
        }

        steps++;
        if (cur == x) {
            return steps;
        }

        int steps1 = -1;
        int steps2 = -1;

        if (cur - b >= x) {
            if (isBackward) {
                backwardVisited[cur] = true;
            } else {
                forwardVisited[cur] = true;
                steps2 = dfs(cur - b, steps, true);
            }
            if (steps2 == -1) {
                steps1 = dfs(cur + a, steps, false);
            }
        } else {
            steps1 = dfs(cur + a, steps, false);
            if (steps1 == -1) {

                if (isBackward) {
                    backwardVisited[cur] = true;
                } else {
                    forwardVisited[cur] = true;
                    steps2 = dfs(cur - b, steps, true);

                }
            }
        }
        return steps1 == -1 ? steps2 : steps1;
    }
}
