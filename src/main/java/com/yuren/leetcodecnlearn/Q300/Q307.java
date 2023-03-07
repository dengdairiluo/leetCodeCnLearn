package com.yuren.leetcodecnlearn.Q300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-11-20 20:21
 */
public class Q307 {
    int[] tree;
    int[] nums;
    int n;

    public Q307(int[] nums) {
        this.nums = nums;
        n = this.nums.length;
        tree = new int[n + 1];
        for (int i = 0; i < n; i++) add(i + 1, this.nums[i]);
    }

    int lowbit(int x) {
        return x & -x;
    }

    int query(int x) {
        int ans = 0;
        for (int i = x; i > 0; i -= lowbit(i)) ans += tree[i];
        return ans;
    }

    void add(int x, int u) {
        for (int i = x; i <= n; i += lowbit(i)) tree[i] += u;
    }

    public void update(int i, int val) {
        add(i + 1, val - nums[i]);
        nums[i] = val;
    }

    public int sumRange(int l, int r) {
        return query(r + 1) - query(l);
    }
}
