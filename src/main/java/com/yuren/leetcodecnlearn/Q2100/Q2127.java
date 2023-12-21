package com.yuren.leetcodecnlearn.Q2100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-21 22:59
 */
public class Q2127 {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int[] inDegrees = new int[n];

        for (int i = 0; i < n; i++)
            inDegrees[favorite[i]]++;

        int[] que = new int[n];
        int read = 0, write = 0;

        for (int i = 0; i < n; i++) {
            if (inDegrees[i] == 0)
                que[write++] = i;
        }

        int[] pathLen = new int[n];
        while (read < write) {
            int curr = que[read++];
            int next = favorite[curr];
            pathLen[next] = Math.max(pathLen[next], pathLen[curr] + 1);
            if (--inDegrees[next] == 0)
                que[write++] = next;
        }

        // leftover nodes are part of cycles and have inDegrees[i] > 0

        int longestCycleLen = 2;
        int sumOfSmallCycles = 0;

        for (int i = 0; i < n; i++) {

            if (inDegrees[i] <= 0) continue;

            int cycleSize = 1;
            int cur = i;
            inDegrees[cur] = 0;
            while (favorite[cur] != i) {
                cycleSize++;
                cur = favorite[cur];
                inDegrees[cur] = 0;
            }

            if (cycleSize == 2) {
                sumOfSmallCycles += cycleSize + pathLen[i] + pathLen[favorite[i]];
            } else {
                longestCycleLen = Math.max(longestCycleLen, cycleSize);
            }

        }

        return Math.max(longestCycleLen, sumOfSmallCycles);
    }
}
