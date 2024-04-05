package com.yuren.leetcodecnlearn.Q2300;

import java.util.TreeSet;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-04-05 下午9:54
 */
public class Q2336 {
    private int thres;
    private TreeSet<Integer> set;

    public Q2336() {
        thres = 1;
        set = new TreeSet<>();
    }

    public int popSmallest() {
        if (set.isEmpty()) {
            int ans = thres;
            ++thres;
            return ans;
        }
        int ans = set.pollFirst();
        return ans;
    }

    public void addBack(int num) {
        if (num < thres) {
            set.add(num);
        }
    }

}
