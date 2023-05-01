package com.yuren.leetcodecnlearn.Q1500;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-05-01 22:41
 */
public class Q1569 {
    static final int MOD = 1000000007;
    long[] fac;
    long[] inv;
    long[] facInv;

    public int numOfWays(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }

        fac = new long[n];
        inv = new long[n];
        facInv = new long[n];
        fac[0] = inv[0] = facInv[0] = 1;
        fac[1] = inv[1] = facInv[1] = 1;
        for (int i = 2; i < n; ++i) {
            fac[i] = fac[i - 1] * i % MOD;
            inv[i] = (MOD - MOD / i) * inv[MOD % i] % MOD;
            facInv[i] = facInv[i - 1] * inv[i] % MOD;
        }

        Map<Integer, TreeNode> found = new HashMap<Integer, TreeNode>();
        UnionFind uf = new UnionFind(n);
        for (int i = n - 1; i >= 0; --i) {
            int val = nums[i] - 1;
            TreeNode node = new TreeNode();
            if (val > 0 && found.containsKey(val - 1)) {
                int lchild = uf.getroot(val - 1);
                node.left = found.get(lchild);
                node.size += node.left.size;
                uf.findAndUnite(val, lchild);
            }
            if (val < n - 1 && found.containsKey(val + 1)) {
                int rchild = uf.getroot(val + 1);
                node.right = found.get(rchild);
                node.size += node.right.size;
                uf.findAndUnite(val, rchild);
            }

            int lsize = node.left != null ? node.left.size : 0;
            int rsize = node.right != null ? node.right.size : 0;
            int lans = node.left != null ? node.left.ans : 1;
            int rans = node.right != null ? node.right.ans : 1;
            node.ans = (int) (fac[lsize + rsize] * facInv[lsize] % MOD * facInv[rsize] % MOD * lans % MOD * rans % MOD);
            found.put(val, node);
        }

        return (found.get(nums[0] - 1).ans - 1 + MOD) % MOD;
    }
}

class TreeNode {
    TreeNode left;
    TreeNode right;
    int size;
    int ans;

    TreeNode() {
        size = 1;
        ans = 0;
    }
}

class UnionFind {
    public int[] parent;
    public int[] size;
    public int[] root;
    public int n;

    public UnionFind(int n) {
        this.n = n;
        parent = new int[n];
        size = new int[n];
        root = new int[n];
        Arrays.fill(size, 1);
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            root[i] = i;
        }
    }

    public int findset(int x) {
        return parent[x] == x ? x : (parent[x] = findset(parent[x]));
    }

    public int getroot(int x) {
        return root[findset(x)];
    }

    public void unite(int x, int y) {
        root[y] = root[x];
        if (size[x] < size[y]) {
            int temp = x;
            x = y;
            y = temp;
        }
        parent[y] = x;
        size[x] += size[y];
    }

    public boolean findAndUnite(int x, int y) {
        int x0 = findset(x);
        int y0 = findset(y);
        if (x0 != y0) {
            unite(x0, y0);
            return true;
        }
        return false;
    }
}
