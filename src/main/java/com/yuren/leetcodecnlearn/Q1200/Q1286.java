package com.yuren.leetcodecnlearn.Q1200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-13 00:18
 */
public class Q1286 {
    private final int[] ans;
    private final int ansLen;
    private final char[] chars;
    private boolean hasNext;
    private int p;
    private final int diff;
    private final int last;

    public Q1286(String characters, int combinationLength) {
        this.ansLen = combinationLength;
        this.last = this.ansLen - 1;
        this.chars = characters.toCharArray();
        int charsLen = chars.length;
        this.hasNext = true;
        this.diff = charsLen - this.ansLen;
        this.ans = new int[this.ansLen];
        for (p = 0; p < this.ansLen; p++) {
            this.ans[p] = p;
        }
        this.p = this.last;
    }

    public String next() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < this.ansLen; i++) {
            sb.append(this.chars[this.ans[i]]);
        }
        this.move2next();
        return sb.toString();
    }

    private void move2next() {
        if (this.ans[p] != diff + p) {
            this.ans[p]++;
        } else {
            // 找到最近一个可以向后移动的较高位置
            while (p >= 0 && this.ans[p] == diff + p) {
                p--;
            }
            if (p >= 0 && this.ans[p] != diff + p) {
                this.ans[p]++;
                for (p = p + 1; p < this.ansLen; p++) {
                    this.ans[p] = this.ans[p - 1] + 1;
                }
                this.p = this.last;
                return;
            } else {
                this.hasNext = false;
                return;
            }
        }
    }

    public boolean hasNext() {
        // 不到结尾就hasNext
        return this.hasNext;
    }
}
