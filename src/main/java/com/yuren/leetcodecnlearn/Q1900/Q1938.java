package com.yuren.leetcodecnlearn.Q1900;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-09-19 23:30
 */
public class Q1938 {

    private int[] counts;
    private List<Integer>[] childIdLists;
    private Map<Integer, Query> nodeIdToQueryMap;
    private int[] answers;
    private int countsOffset;

    public int[] maxGeneticDifference(int[] parents, int[][] queries) {

        int numNodes = parents.length;

        childIdLists = new List[numNodes];
        for (int i = 0; i < numNodes; i++) {
            childIdLists[i] = new ArrayList<>();
        }

        int rootId = -1;

        for (int i = 0; i < numNodes; i++) {
            int parentId = parents[i];
            if (parentId >= 0) {
                childIdLists[parentId].add(i);
            } else {
                rootId = i;
            }
        }

        nodeIdToQueryMap = new HashMap<>();
        for (int i = 0; i < queries.length; i++) {
            int[] queryArr = queries[i];
            Query query = new Query(i, queryArr[1]);
            query.next = nodeIdToQueryMap.put(queryArr[0], query);
        }

        countsOffset = numNodes == Integer.lowestOneBit(numNodes) ? numNodes : Integer.highestOneBit(numNodes) << 1;

        counts = new int[numNodes + 1 + countsOffset];

        answers = new int[queries.length];

        dfs(rootId);

        return answers;
    }

    private void dfs(int nodeId) {

        for (int index = countsOffset + nodeId; index > 0; index >>= 1) {
            counts[index]++;
        }

        Query query = nodeIdToQueryMap.remove(nodeId);
        for (; query != null; query = query.next) {
            int index = 1;
            int value = query.value;
            int bit = countsOffset >> 1;
            while (index < countsOffset) {
                int leftIndex = index << 1;
                int rightIndex = leftIndex + 1;
                if (counts[leftIndex] > 0 && (counts[rightIndex] == 0 || (value & bit) != 0)) {
                    index = leftIndex;
                } else {
                    index = rightIndex;
                    value ^= bit;
                }
                bit >>= 1;
            }
            answers[query.queryId] = value;
        }

        for (int childId : childIdLists[nodeId]) {
            dfs(childId);
        }

        for (int index = countsOffset + nodeId; index > 0; index >>= 1) {
            counts[index]--;
        }
    }

    private static class Query {

        int queryId;
        int value;
        Query next;

        public Query(int id, int v) {
            queryId = id;
            value = v;
        }
    }
}
