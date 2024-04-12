package com.yuren.leetcodecnlearn.Q1600;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-05-14 23:58
 */
public class Q1601 {
    List<int[]>[] graph;
    int[][] req;
    Integer[] dp;
    int reqLen;
    /*
     * tempMask helps update the mask to reflect all edges used up in the cycle
     */
    int tempMask;
    int currentCycleSize;

    public int maximumRequests(int n, int[][] requests) {
        int uselessRequests = 0;
        //count requests of type [x,x] (transfer requests into same building)
        for (int[] rq : requests) {
            if (rq[0] == rq[1]) {
                uselessRequests++;
            }
        }

        reqLen = requests.length - uselessRequests;
        req = new int[reqLen][2];

        int st = 0;

        //Create new requests array after removing useless Requests
        for (int[] rq : requests) {
            if (rq[0] != rq[1]) {
                req[st++] = rq;
            }
        }

        //create data structure
        //graph is needed for quick access to neighbors of a vertex
        graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < reqLen; i++) {
            graph[req[i][0]].add(new int[]{req[i][1], i});
        }

        dp = new Integer[1 << reqLen];

        return findMaxRequests(0) + uselessRequests;
    }

    private int findMaxRequests(int mask) {
        if (dp[mask] != null) {
            return dp[mask];
        }

        int resuslt = 0;
        for (int i = 0; i < reqLen; i++) {
            if ((mask & (1 << i)) == 0) {
                //set mask
                mask = mask | (1 << i);

                //check for any cycle
                int cycleLength = getCycleLength(req[i], mask);

                if (cycleLength != -1) {
                    //tempMask includes current edge plus all edges used up in the cycle we found)
                    resuslt = Math.max(resuslt, cycleLength + findMaxRequests(tempMask));        //solve for rest of the edges
                }
                //Backtrack and unset mask
                mask = mask ^ (1 << i);
            }
        }
        dp[mask] = resuslt;
        return resuslt;
    }

    int getCycleLength(int[] edge, int msk) {
        tempMask = msk;
        currentCycleSize = -1;
        if (dfs(edge[1], edge[0], 1)) {
            return currentCycleSize;
        }
        return -1;
    }

    boolean dfs(int currentVertex, int endVertex, int currentDepth) {
        if (currentVertex == endVertex) {
            currentCycleSize = currentDepth;
            return true;
        }

        for (int[] neighbor : graph[currentVertex]) {
            int indexInEdgeArray = neighbor[1];
            if ((tempMask & (1 << indexInEdgeArray)) == 0) {
                //Set mask
                tempMask = (tempMask | (1 << indexInEdgeArray));
                //search for any cycle
                if (dfs(neighbor[0], endVertex, currentDepth + 1)) {
                    return true;
                } else {
                    //Unset mask if not cycle found using this edge
                    tempMask = (tempMask ^ (1 << indexInEdgeArray));
                }
            }
        }
        return false;
    }
}
