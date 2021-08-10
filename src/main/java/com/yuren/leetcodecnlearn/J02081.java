package com.yuren.leetcodecnlearn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class J02081 {
    private static List<List<Integer>> res;

    public static void main(String[] args) {
        combinationSum(new int[]{2, 3, 6, 7}, 7);
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);
        res = new LinkedList<>();
        List<Integer> temp = new LinkedList<>();
        dfs(0, candidates, target, 0, temp);
        return res;
    }

    private static void dfs(int i, int[] candidates, int target, int currSum, List<Integer> temp) {

        if (currSum >= target) {
            if (currSum == target) {
                res.add(new LinkedList<>(temp));
            }
            return;
        }
        if (i > candidates.length - 1) {
            return;
        }

        if (currSum + candidates[i] > target) {
            return;
        }
        dfs(i + 1, candidates, target, currSum, temp);
        temp.add(candidates[i]);
        dfs(i, candidates, target, currSum + candidates[i], temp);
        temp.remove(temp.size() - 1);

    }
}
