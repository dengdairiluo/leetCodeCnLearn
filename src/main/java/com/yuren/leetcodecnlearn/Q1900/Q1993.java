package com.yuren.leetcodecnlearn.Q1900;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-10-15 00:25
 */
public class Q1993 {
    int[] locker, left, right;
    int[] linkNext, linkItem, linkHead;

    int[] locks;
    int[] queue, lockQueueIdx;
    int queueTail = -1;
    int[] tmpQueue;

    int[] depth;
    int orderTail = 2000;

    public Q1993(int[] parent) {
        final int n = parent.length;

        this.locks = new int[n];
        this.queue = new int[n];
        this.lockQueueIdx = new int[n];
        this.tmpQueue = new int[n];

        this.locker = new int[n];
        this.left = new int[n];
        this.right = new int[n];

        this.linkNext = new int[n + 1];
        this.linkItem = new int[n + 1];
        this.linkHead = new int[n];

        this.depth = new int[n];

        Arrays.fill(locker, -1);

        for (int cur = 1, linkTail = 0, par = -1; cur < n; cur++) {
            par = parent[cur];
            linkNext[++linkTail] = linkHead[par];
            linkHead[par] = linkTail;
            linkItem[linkTail] = cur;
        }

        dfs(0, 0);
    }

    private void dfs(int cur, int curDepth) {
        depth[cur] = curDepth;
        if (linkHead[cur] == 0) {
            left[cur] = right[cur] = --orderTail;
            return;
        }

        int leftBoundary = 0, rightBoundary = linkItem[linkHead[cur]];
        for (int idx = linkHead[cur]; idx > 0; idx = linkNext[idx]) {
            dfs(leftBoundary = linkItem[idx], curDepth + 1);
        }

        left[cur] = left[leftBoundary];
        right[cur] = right[rightBoundary];
    }

    public boolean lock(int num, int user) {
        if (locker[num] > -1) return false;
        locker[num] = user;
        queue[++queueTail] = num;
        lockQueueIdx[num] = queueTail;
        return true;
    }

    public boolean unlock(int num, int user) {
        if (locker[num] != user) return false;
        locker[num] = -1;
        int tailNum = queue[queueTail--];
        queue[lockQueueIdx[num]] = tailNum;
        lockQueueIdx[tailNum] = lockQueueIdx[num];
        return true;
    }

    public boolean upgrade(int num, int user) {
        if (locker[num] > -1 || queueTail < 0) return false;

        int tmpQueueTail = -1;
        for (int i = 0; i <= queueTail; i++) {
            int lockNum = queue[i];
            if (depth[lockNum] < depth[num]) {
                if (left[lockNum] <= left[num] && right[num] <= right[lockNum]) {
                    return false;
                }
            } else {
                if (left[num] <= left[lockNum] && right[lockNum] <= right[num]) {
                    tmpQueue[++tmpQueueTail] = lockNum;
                }
            }
        }

        if (tmpQueueTail == -1) return false;

        for (int i = 0; i <= tmpQueueTail; i++) {
            unlock(tmpQueue[i], locker[tmpQueue[i]]);
        }

        lock(num, user);

        return true;
    }
}
