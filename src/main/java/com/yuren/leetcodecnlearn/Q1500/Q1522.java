package com.yuren.leetcodecnlearn.Q1500;

import com.yuren.leetcodecnlearn.entity.Node;

import java.util.Arrays;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-04-13 23:42
 */
public class Q1522 {
    /**
     * 记录最大的直径
     */
    int ans = 0;

    public int diameter(Node root) {
        dfs(root);
        return ans;
    }

    //求解子树的高度
    public int dfs(Node node) {
        //如果子树为null，返回树高0
        if (node == null) {
            return 0;
        }

        //获取孩子节点
        List<Node> list = node.children;
        //当前节点为叶子节点时，返回树高1
        if (list.isEmpty()) {
            return 1;
        }

        //维护子树高度
        int[] heights = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            Node val = list.get(i);
            //递归求解子树高度
            heights[i] = dfs(val);
        }

        //当前节点只有一个子树时
        if (heights.length == 1) {
            //和当前记录的最大直径比较
            ans = Math.max(ans, heights[heights.length - 1]);
            return heights[0] + 1;
        }

        //当前节点有多个子树时，对数组进行排序，取出最大的两个子树高度，即可。
        Arrays.sort(heights);
        ans = Math.max(ans, heights[heights.length - 1] + heights[heights.length - 2]);
        return heights[heights.length - 1] + 1;
    }
}
