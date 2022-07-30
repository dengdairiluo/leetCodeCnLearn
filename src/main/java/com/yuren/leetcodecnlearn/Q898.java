package com.yuren.leetcodecnlearn;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-07-30 22:04
 */
public class Q898 {
    public int subarrayBitwiseORs(int[] arr ) {
        int n = arr.length;
        Set<Integer> set = new HashSet<>(n * 3);
        List<Integer> list = Collections.emptyList();
        for (int j : arr) {
            List<Integer> nextList = new ArrayList<>(list.size() + 1);
            int pre = j;
            set.add(pre);
            nextList.add(pre);
            for (int x : list) {
                int v = pre | x;
                if (v > pre) {
                    nextList.add(v);
                }
                pre = v;
                set.add(pre);
            }
            list = nextList;
        }
        return set.size();
    }
}
