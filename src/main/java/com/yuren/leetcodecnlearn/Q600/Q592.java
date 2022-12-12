package com.yuren.leetcodecnlearn.Q600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-03-19 21:53
 */
public class Q592 {
    public String fractionAddition(String expression) {
        MaxNumber ans = new MaxNumber();
        char[] cs = expression.toCharArray();
        int len = cs.length;
        int up = 0, down = 1;
        char op = '+';
        int p = 0;
        boolean isUp = true;
        while (p < len) {
            char c = cs[p];
            if (c == '+' || c == '-') {
                if (op == '+') {
                    ans = ans.add(up, down);
                } else {
                    ans = ans.sub(up, down);
                }
                op = c;
                up = 0;
                isUp = true;
            } else if (c == '/') {
                isUp = false;
                down = 0;
            } else if (isUp) {
                up = up * 10 + c - '0';
            } else {
                down = down * 10 + c - '0';
            }
            p++;
        }
        if (op == '+') {
            ans.add(up, down);
        } else {
            ans.sub(up, down);
        }
        return ans.toString();
    }

    private static class MaxNumber {
        int up;
        int down;

        public MaxNumber() {
            this.up = 0;
            this.down = 1;
        }

        public MaxNumber(int up, int down) {
            this.up = up;
            this.down = down;
        }

        public MaxNumber add(int up, int down) {
            if (this.down == down) {
                this.up = this.up + up;
            } else {
                int gcd = this.gcd(this.down, down);
                int mul1 = this.down / gcd;
                int mul2 = down / gcd;
                this.down = this.down * mul2;
                this.up = this.up * mul2 + up * mul1;
            }
            this.div();
            return this;
        }

        public MaxNumber sub(int up, int down) {
            if (this.down == down) {
                this.up = this.up - up;
            } else {
                int gcd = this.gcd(this.down, down);
                int mul1 = this.down / gcd;
                int mul2 = down / gcd;
                this.down = this.down * mul2;
                this.up = this.up * mul2 - up * mul1;
            }
            this.div();
            return this;
        }

        private void div() {
            int gcd = Math.abs(gcd(this.down, this.up));
            this.down = this.down / gcd;
            this.up = this.up / gcd;
        }

        private int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }

        @Override
        public String toString() {
            return this.up + "/" + this.down;
        }
    }
}
