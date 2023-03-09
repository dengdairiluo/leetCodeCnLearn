package com.yuren.leetcodecnlearn.Q1400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-03-09 23:53
 */
public class Q1439 {
    private int m, n, k;
    private int[][] mat;
    /**
     * 计算小于等于当前数组和的数量
     */
    private int cnt = 0;

    public int kthSmallest(int[][] mat, int k) {
        this.k = k;
        this.mat = mat;
        m = mat.length;
        n = mat[0].length;
        // 搜索范围
        int left = 0, right = 0;
        for (int i = 0; i < m; i++) {
            left += mat[i][0];
            right += mat[i][n - 1];
        }
        // 把最小值设为初始值
        int init = left;
        while (left <= right) {
            int mid = left - (left - right) / 2;
            // 初始值也算一个可行解
            cnt = 1;
            dfs(0, init, mid);
            // 对应数组和大了，向左收缩
            if (cnt >= k) {
                right = mid - 1;
            }
            // 对应数组和小了，向右收缩
            else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * DFS 计算 小于等于 target 的数量
     *
     * @param row
     * @param sum
     * @param target
     */
    private void dfs(int row, int sum, int target) {
        // 特殊情况，直接返回
        // sum > target：当前数组和大于 target
        // cnt > k：当前小于等于 target 的数量大于 k
        // row >= m：已经到达最后一行 (结束条件)
        if (sum > target || cnt > k || row >= m) {
            return;
        }
        // 不做交换
        dfs(row + 1, sum, target);
        // 分别与 [1, n-1] 交换
        for (int i = 1; i < n; i++) {
            // 更新数组和：减去「第一个元素」，加上「要交换的元素」
            int newSum = sum - mat[row][0] + mat[row][i];
            // 交换后的数组和大于 target，直接跳出循环
            // 原因：由于每行元素递增，所以当前元素大了，该行后面的元素肯定也大了
            if (newSum > target) {
                break;
            }
            // 满足要求，cnt + 1
            cnt++;
            // 搜索下一行
            dfs(row + 1, newSum, target);
        }
    }


}
