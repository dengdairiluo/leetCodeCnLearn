package com.yuren.leetcodecnlearn.Q1700;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-07-16 23:20
 */
public class Q1766 {
    private static final int MAX_NUM = 50;

    private static final boolean[][] IS_COPRIME = new boolean[MAX_NUM + 1][MAX_NUM + 1];

    static {
        for (int i = 1; i <= MAX_NUM; i++) {
            for (int j = 1; j < i; j++) {
                IS_COPRIME[j][i] = IS_COPRIME[i][j] = j == 1 || IS_COPRIME[j][i % j];
            }
            IS_COPRIME[i][i] = i == 1;
        }
    }

    private List<Integer>[] adjIdLists;

    private int[] nums;

    private int[] results;

    private List<Integer> ancestorIds;

    private int[] numDepths;

    public int[] getCoprimes(int[] nums, int[][] edges) {

        this.nums = nums;

        adjIdLists = new List[nums.length];
        for (int i = 0; i < nums.length; i++) {
            adjIdLists[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjIdLists[u].add(v);
            adjIdLists[v].add(u);
        }

        numDepths = new int[MAX_NUM + 1];
        Arrays.fill(numDepths, -1);

        ancestorIds = new ArrayList<>();

        results = new int[nums.length];

        dfsGetCoprimes(0, -1);

        return results;
    }


    private void dfsGetCoprimes(int nodeId, int parentId) {
        int num = nums[nodeId];
        int nearestDepth = -1;
        int nearestId = -1;
        for (int i = 1; i <= MAX_NUM; i++) {
            if (IS_COPRIME[i][num] == false) {
                continue;
            }
            int depth = numDepths[i];
            if (depth <= nearestDepth) {
                continue;
            }
            nearestDepth = depth;
            nearestId = ancestorIds.get(depth);
        }
        results[nodeId] = nearestId;

        int prevDepth = numDepths[num];
        numDepths[num] = ancestorIds.size();
        ancestorIds.add(nodeId);

        for (int childId : adjIdLists[nodeId]) {
            if (childId == parentId) {
                continue;
            }
            dfsGetCoprimes(childId, nodeId);
        }

        numDepths[num] = prevDepth;
        ancestorIds.remove(ancestorIds.size() - 1);
    }
}
