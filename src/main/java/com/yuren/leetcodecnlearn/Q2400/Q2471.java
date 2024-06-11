package com.yuren.leetcodecnlearn.Q2400;

import com.yuren.leetcodecnlearn.entity.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-06-11 下午11:52
 */
public class Q2471 {
    private static int[] map = new int[100010];

    public int minimumOperations(TreeNode root) {
        int ans = 0;
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int len = deque.size();
            int[] nums = new int[len], bak = new int[len];
            int cnt = 0, idx = 0;
            for (int i = 0; i < len; i++) {
                TreeNode treeNode = deque.pollFirst();
                nums[i] = bak[i] = treeNode.val;
                map[nums[i]] = i;
                if (treeNode.left != null) deque.addLast(treeNode.left);
                if (treeNode.right != null) deque.addLast(treeNode.right);
            }
            Arrays.sort(bak);
            for (int i = 0; i < nums.length; i++) {
                int targetIdx = map[bak[i]];
                if (targetIdx != i) {
                    ans++;
                    int t = nums[targetIdx];
                    nums[targetIdx] = nums[i];
                    nums[i] = t;
                    map[nums[i]] = i;
                    map[nums[targetIdx]] = targetIdx;
                }
            }
        }
        return ans;
    }
}
