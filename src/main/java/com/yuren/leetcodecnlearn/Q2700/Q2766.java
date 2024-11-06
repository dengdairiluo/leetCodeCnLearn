package com.yuren.leetcodecnlearn.Q2700;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-11-06 23:36
 */
public class Q2766 {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        // 预分配空间，效率更高
        Set<Integer> set = new HashSet<>(nums.length);
        for (int x : nums) {
            set.add(x);
        }

        for (int i = 0; i < moveFrom.length; i++) {
            set.remove(moveFrom[i]);
            set.add(moveTo[i]);
        }

        List<Integer> ans = new ArrayList<>(set);
        Collections.sort(ans);
        return ans;
    }
}
