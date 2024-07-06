package com.yuren.leetcodecnlearn.Q2500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-07-06 下午11:43
 */
public class Q2519 {
    int[] treeleft, treeright;//双树状数组
    int n;

    public int kBigIndices(int[] nums, int k) {
        this.n = nums.length;
        this.treeleft = new int[n + 1];
        this.treeright = new int[n + 1];
        for (int i : nums) update(treeright, i + 1, 1);//先初始化右边树
        int ans = 0;
        for (int i : nums) {
            update(treeright, i + 1, -1);//右边树去掉当前结点
            if (query(treeright, i) >= k && query(treeleft, i) >= k) ans++;//左右两边比i小的数，都满足条件
            update(treeleft, i + 1, 1);//当前结点更新到左边树中
        }
        return ans;
    }

    public int lowBit(int x) {
        return x & -x;
    }

    public void update(int[] tree, int x, int dt) {
        while (x <= n) {
            tree[x] += dt;
            x += lowBit(x);
        }
    }

    public int query(int[] tree, int x) {
        int res = 0;
        while (x > 0) {
            res += tree[x];
            x -= lowBit(x);
        }
        return res;
    }
}

