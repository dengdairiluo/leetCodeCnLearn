package com.yuren.leetcodecnlearn.Q600;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-05-06 06:46
 */
public class Q699 {
    private int N;
    private int[] max;
    private Integer[] update;

    public List<Integer> fallingSquares(int[][] positions) {
        HashMap<Integer, Integer> map = index(positions);
        N = map.size();
//		N = this.arraySize(positions) + 1;// range()数组最大数
        int m = N << 2; // 线段树长度 == 数组长度 * 4
        max = new int[m];// 最大值缓存结构
        update = new Integer[m]; // 更新缓存结构
        int start = 1; // 线段树最小索引
        int root = 1; // 线段树的根index
        List<Integer> ans = new ArrayList<>(); // 答案
        int max = 0; // 当前最大高度
        for (int i = 0; i < positions.length; i++) {
            int[] position = positions[i]; // 当前掉落的方块
            int L = map.get(position[0]); // 当前掉落左边界
            int R = map.get(position[0] + position[1] - 1); // 当前掉落右边界
//			int L = position[0]; // 当前掉落左边界
//			int R = position[0] + position[1] - 1; // 当前掉落右边界
            int height = this.query(L, R, start, N, root) + position[1]; // 掉落前这一段的最大高度 + 新增高度 == 这一段掉落后高度
            max = Math.max(max, height);// 掉落后的最大高度
            ans.add(max);
            this.update(L, R, height, start, N, root); // [L,R] 上都变成 height (下面有空的也没事)
        }
        return ans;
    }

    private void update(int L, int R, int H, int l, int r, int root) {
        if (L <= l && r <= R) {
            this.update[root] = H;// 当前范围属于更新范围内, 由root代表
            this.max[root] = H;
            return;
        }
        int mid = (l + r) >> 1;
        this.push(root);
        if (L <= mid) {
            this.update(L, R, H, l, mid, root << 1);
        }
        if (R > mid) {
            this.update(L, R, H, mid + 1, r, (root << 1) | 1);
        }
        // 当前点最大值
        max[root] = Math.max(max[root << 1], max[(root << 1) | 1]);
    }

    private void push(int root) {
        if (this.update[root] != null) {
            int update = this.update[root];
            this.update[root << 1] = update;// 左子树
            this.update[(root << 1) | 1] = update;// 右子树
            this.max[root << 1] = update;
            this.max[(root << 1) | 1] = update;
            this.update[root] = null;
        }
    }

    private Integer query(int L, int R, int l, int r, int root) {
        if (L <= l && r <= R) {
            return this.max[root];
        }
        int mid = (l + r) >> 1;
        this.push(root);
        int maxLeft = 0;
        int maxRight = 0;
        if (L <= mid) {
            maxLeft = this.query(L, R, l, mid, root << 1);
        }
        if (R > mid) {
            maxRight = this.query(L, R, mid + 1, r, (root << 1) | 1);
        }
        return Math.max(maxLeft, maxRight);
    }

    private int arraySize(int[][] positions) {
        int maxNumber = 0;
        for (int[] position : positions) {
            maxNumber = Math.max(position[0] + position[1], maxNumber);
        }
        return maxNumber + 1; // 数组长度
    }

    public HashMap<Integer, Integer> index(int[][] positions) {
        TreeSet<Integer> pos = new TreeSet<>();
        for (int[] arr : positions) {
            pos.add(arr[0]);
            pos.add(arr[0] + arr[1] - 1);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (Integer index : pos) {
            map.put(index, ++count);
        }
        return map;
    }
}
