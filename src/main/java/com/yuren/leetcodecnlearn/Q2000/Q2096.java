package com.yuren.leetcodecnlearn.Q2000;

import com.yuren.leetcodecnlearn.entity.TreeNode;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-06 22:37
 */
public class Q2096 {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder sb = new StringBuilder();

        dfs(root, startValue, sb);
        String path1 = sb.toString();

        sb.setLength(0);
        dfs(root, destValue, sb);
        String path2 = sb.toString();

        int index = 0;
        while (index < path1.length() && index < path2.length()) {
            if (path1.charAt(index) == path2.charAt(index)) {
                index++;
            } else {
                break;
            }
        }

        sb.setLength(0);
        for (int i = index; i < path1.length(); i++) {
            sb.append('U');
        }
        sb.append(path2.substring(index));

        return sb.toString();
    }

    private boolean dfs(TreeNode node, int val, StringBuilder sb) {
        if (node.val == val) {
            return true;
        }

        if (node.left != null) {
            sb.append('L');
            if (dfs(node.left, val, sb)) {
                return true;
            }
            sb.deleteCharAt(sb.length() - 1);
        }

        if (node.right != null) {
            sb.append('R');
            if (dfs(node.right, val, sb)) {
                return true;
            }
            sb.deleteCharAt(sb.length() - 1);
        }

        return false;
    }
}
