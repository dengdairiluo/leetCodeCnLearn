package com.yuren.leetcodecnlearn.Q1100;

import com.yuren.leetcodecnlearn.entity.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-10-30 22:43
 */
public class Q1110 {
    Set<Integer> toDeleteSet = new HashSet<>();
    List<TreeNode> forest = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] toDelete) {
        for (int i : toDelete) {
            // 哈希表存储删除的数
            toDeleteSet.add(i);
        }
        addNodeToList(root);
        if (root != null && !toDeleteSet.contains(root.val)) {
            //根节点单独判断
            forest.add(root);
        }
        return forest;
    }

    /**
     * root不是被删除节点或null，就返回其本身， 否则返回null
     *
     * @param root
     * @return
     */
    private TreeNode addNodeToList(TreeNode root) {
        if (root == null) return null;
        // 这里用 root.left、root.right 接收返回值，返回null就断开连接了
        root.left = addNodeToList(root.left);      // 遍历其左孩子情况
        root.right = addNodeToList(root.right);    // 遍历其右孩子情况
        if (toDeleteSet.contains(root.val)) {   // 父节点是被删除的值，需要添加其左右孩子到森林中
            if (root.left != null) forest.add(root.left);
            if (root.right != null) forest.add(root.right);
            root = null;
        }
        return root;
    }
}
