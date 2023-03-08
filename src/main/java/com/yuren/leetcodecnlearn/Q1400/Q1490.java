package com.yuren.leetcodecnlearn.Q1400;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q1490 {
    public Node cloneTree1(Node root) {
        if (root == null) {
            return null;
        }
        // 复制当前节点
        Node cloneRoot = new Node(root.val);
        for (Node child : root.children) {
            // 进入孩子节点中，复制孩子节点
            cloneRoot.children.add(cloneTree1(child));
        }
        return cloneRoot;
    }

    public Node cloneTree2(Node root) {
        if (root == null) {
            return null;
        }
        Node cloneRoot = new Node(root.val);// 复制树的root
        Queue<Node> queue = new LinkedList<>();// 原树的辅助队列
        queue.offer(root);// root入队列
        Queue<Node> cloneQueue = new LinkedList<>();// 复制树的辅助队列
        cloneQueue.offer(cloneRoot);// root入队列
        while (!queue.isEmpty()) {
            // 获取原树和复制树的当前节点
            Node node = queue.poll();
            Node cloneNode = cloneQueue.poll();
            for (Node child : node.children) {
                // 复制原树孩子节点，加入children中
                Node cloneChild = new Node(child.val);
                cloneNode.children.add(cloneChild);
                // 原树孩子节点和复制树孩子节点进入队列
                queue.offer(child);
                cloneQueue.offer(cloneChild);
            }
        }
        return cloneRoot;
    }

    private static class Node {
        public int val;
        public List<Node> children;


        public Node() {
            children = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }


}
