package com.yuren.leetcodecnlearn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-01-03 23:49
 */
public class Q428 {
    private static final String L_BOUND = "[";
    private static final String R_BOUND = "]";

    public String serialize(Node root) {
        if (root == null) return "";

        StringBuilder builder = new StringBuilder();
        dfsEnocde(root, builder);
        return builder.toString();
    }

    private void dfsEnocde(Node root, StringBuilder builder) {
        if (root == null) {
            return;
        }

        builder.append(root.val);
        builder.append(" ");

        if (root.children.isEmpty()) {
            return;
        }

        // 特意多写这个append(" ")，这个在左String.split时候是必要的，和num区分
        builder.append(L_BOUND).append(" ");
        for (int i = 0; i < root.children.size(); i++) {
            Node child = root.children.get(i);
            dfsEnocde(child, builder);
        }
        builder.append(R_BOUND).append(" ");
    }

    public Node deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }

        String[] arr = data.split(" ");
        LinkedList<Node> stack = new LinkedList<>();
        Node root = new Node(Integer.parseInt(arr[0]), new ArrayList<>());
        dfsDecode(stack, root, arr, 1);
        return root;
    }

    private void dfsDecode(LinkedList<Node> stack, Node pre, String[] arr, int index) {
        if (index == arr.length) return;

        if ("[".equals(arr[index])) {
            stack.push(pre);
            // 只push pre节点，继续递归
            dfsDecode(stack, pre, arr, index + 1);
        } else if ("]".equals(arr[index])) {
            stack.pop(); // 返回parent节点
            dfsDecode(stack, pre, arr, index + 1); // pop栈顶节点后，还必须递归，不然到"]"就终止递归了
        } else {
            Node cur = new Node(Integer.valueOf(arr[index]), new ArrayList<>());
            stack.peek().children.add(cur);
            dfsDecode(stack, cur, arr, index + 1);
        }
    }

    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
