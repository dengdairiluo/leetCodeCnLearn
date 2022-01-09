package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-01-09 21:30
 */
public class Q440 {
    public int findKthNumber(int n, int k) {
        // 当前遍历到的数字，从1（根）出发
        long cur = 1;
        // 从1出发开始往后按字典序从小到大的顺序走k-1步到达的就是 字典序的第K小数字
        k = k - 1;

        while (k > 0) {
            int nodes = getNodes(n, cur);
            // 向右侧节点走：字典序上升nodes位
            if (k >= nodes) {
                k = k - nodes;
                // 当前数字 cur = cur + 1
                cur++;
                // 向下往最左孩子节点走:字典序上升1位
            } else {
                k = k - 1;
                // 当前数字 cur = cur * 10
                cur *= 10;
            }
        }
        // 最后cur停在的数字就是字典序的第K小数字
        return (int) cur;
    }

    /**
     * 计算以cur为根的子树节点数目，所有节点的值必须 <= n
     *
     * @param n
     * @param cur
     * @return
     */
    private int getNodes(int n, long cur) {
        // 当前节点右侧右边节点的值
        long next = cur + 1;
        // 记录子树中的全部节点数目
        long totalNodes = 0;
        while (cur <= n) {
            totalNodes += Math.min(n - cur + 1, next - cur);
            next *= 10;
            cur *= 10;
        }
        return (int) totalNodes;
    }
}
