package com.yuren.leetcodecnlearn.Q1800;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-09-01 23:24
 */
public class Q1896 {

    private static class FlipResult {
        boolean value;
        int minOp;

        public FlipResult(boolean value, int minOp) {
            this.value = value;
            this.minOp = minOp;
        }
    }

    private int i;

    private String expression;

    public int minOperationsToFlip(String expression) {
        this.expression = expression;
        this.i = 0;
        FlipResult result = dfsFlip();
        return result.minOp;
    }

    private char nextChar() {
        if (i >= expression.length()) {
            return 0;
        }
        return expression.charAt(i++);
    }

    private FlipResult dfsFlip() {
        FlipResult left = null;
        for (char c; (c = nextChar()) != 0 && c != ')'; ) {
            char op = 0;
            if (left != null) {
                if (c != '|' && c != '&') {
                    throw new RuntimeException();
                }
                op = c;
                c = nextChar();
            }
            FlipResult right;
            if (c == '(') {
                right = dfsFlip();
            } else if (c == '0' || c == '1') {
                right = new FlipResult(c == '1', 1);
            } else {
                throw new RuntimeException();
            }

            if (left == null) {
                left = right;
            } else {
                boolean value;
                int minOp;
                if (op == '&') {
                    value = left.value & right.value;
                    if (value) {
                        minOp = Math.min(left.minOp, right.minOp);
                    } else {
                        minOp = (left.value || right.value) ? 1 : 1 + Math.min(left.minOp, right.minOp);
                    }
                } else {
                    value = left.value | right.value;
                    if (value) {
                        minOp = (left.value && right.value) ? 1 + Math.min(left.minOp, right.minOp) : 1;
                    } else {
                        minOp = Math.min(left.minOp, right.minOp);
                    }
                }
                left = new FlipResult(value, minOp);
            }
        }

        return left;
    }
}
