package com.yuren.leetcodecnlearn.Q1500;

import java.util.*;

public class Q1577 {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> endSet = new HashSet<>();
        for (List<Integer> edge : edges) {
            endSet.add(edge.get(1));
        }
        for (int i = 0; i < n; i++) {
            if (!endSet.contains(i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    public int numTriplets(int[] nums1, int[] nums2) {
        Map<Long, Integer> map = getMap(nums1);
        int count = 0;
        count += counting(map, nums2);

        map = getMap(nums2);
        count += counting(map, nums1);

        return count;
    }

    private Map<Long, Integer> getMap(int[] nums) {
        Map<Long, Integer> map = new HashMap<>();

        for (int x : nums) {
            long square = (long) x * x;
            map.put(square, map.getOrDefault(square, 0) + 1);
        }
        return map;
    }

    private int counting(Map<Long, Integer> map, int[] nums) {
        int n = nums.length;
        int total = 0;
        Arrays.sort(nums);

        for (long key : map.keySet()) {
            int count = map.get(key);
            int left = 0, right = n - 1;

            while (left < right) {
                long product = (long) nums[left] * nums[right];
                if (product < key) {
                    left++;
                } else if (product > key) {
                    right--;
                } else {
                    if (nums[left] == nums[right]) {
                        total += count * (right - left + 1) * (right - left) / 2;
                        break;
                    } else {
                        int countLeft = 1;
                        int countRight = 1;

                        while (nums[left] == nums[++left]) {
                            countLeft++;
                        }
                        while (nums[right] == nums[--right]) {
                            countRight++;
                        }

                        total += count * countLeft * countRight;
                    }
                }
            }
        }
        return total;
    }
}
