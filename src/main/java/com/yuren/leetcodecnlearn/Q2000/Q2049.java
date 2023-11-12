package com.yuren.leetcodecnlearn.Q2000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-11-12 20:03
 */
public class Q2049 {
    int ans = 0;
    long max = 0;
    int n;
    private int[] leftArr;
    private int[] rightArr;

    public int countHighestScoreNodes(int[] parents) {
        n = parents.length;
        leftArr = new int[n];
        rightArr = new int[n];

        for (int i = 0; i < n; i++) {
            leftArr[i] = -1;
            rightArr[i] = -1;
        }

        for (int i = 1; i < n; i++) {
            int p = parents[i];
            if (leftArr[p] == -1) {
                leftArr[p] = i;
            } else {
                rightArr[p] = i;
            }
        }
        dfs(0);
        return ans;
    }

    private int dfs(int val) {
        if (val == -1) {
            return 0;
        }
        int ln = dfs(leftArr[val]);
        int rn = dfs(rightArr[val]);
        int remain = n - ln - rn - 1;
        long score = trans(ln) * trans(rn) * trans(remain);
        if (score == max) {
            ans++;
        } else if (score > max) {
            max = score;
            ans = 1;
        }
        return ln + rn + 1;
    }

    private long trans(int val) {
        return val == 0 ? 1 : val;
    }
}
