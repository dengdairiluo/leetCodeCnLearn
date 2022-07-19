package com.yuren.leetcodecnlearn;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-07-19 22:38
 */
public class Q870 {
    public int[] advantageCount(int[] A, int[] B) {
        int[] sortedA = A.clone();
        Arrays.sort(sortedA);
        int[] sortedB = B.clone();
        Arrays.sort(sortedB);

        // assigned[b] = list of a that are assigned to beat b
        Map<Integer, Deque<Integer>> assigned = new HashMap<>();
        for (int b : B) {
            assigned.put(b, new LinkedList<>());
        }

        // remaining = list of a that are not assigned to any b
        Deque<Integer> remaining = new LinkedList<>();

        // populate (assigned, remaining) appropriately
        // sortedB[j] is always the smallest unassigned element in B
        int j = 0;
        for (int a : sortedA) {
            if (a > sortedB[j]) {
                assigned.get(sortedB[j++]).add(a);
            } else {
                remaining.add(a);
            }
        }

        // Reconstruct the answer from annotations (assigned, remaining)
        int[] ans = new int[B.length];
        for (int i = 0; i < B.length; ++i) {
            // if there is some a assigned to b...

            if (assigned.get(B[i]).size() > 0) {
                ans[i] = assigned.get(B[i]).pop();
            } else {
                ans[i] = remaining.pop();
            }
        }
        return ans;
    }
}
