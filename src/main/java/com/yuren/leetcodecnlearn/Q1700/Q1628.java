package com.yuren.leetcodecnlearn.Q1700;

import java.util.Stack;

public class Q1628 {

    Node buildTree(String[] postfix) {
        Stack<OpNode> stack = new Stack<>();
        for (String s : postfix) {
            OpNode node = new OpNode(s);
            if ("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s)) {
                node.right = stack.pop();
                node.left = stack.pop();
            }
            stack.push(node);
        }
        return stack.pop();
    }

    abstract class Node {
        public abstract int evaluate();
    }

    private class OpNode extends Node {
        String value;
        private OpNode left;
        private OpNode right;

        public OpNode(String value) {
            this.value = value;
        }

        @Override
        public int evaluate() {
            switch (value) {
                case "+":
                    return left.evaluate() + right.evaluate();
                case "-":
                    return left.evaluate() - right.evaluate();
                case "*":
                    return left.evaluate() * right.evaluate();
                case "/":
                    return left.evaluate() / right.evaluate();
                default:
                    return Integer.parseInt(value);

            }
        }
    }

}
