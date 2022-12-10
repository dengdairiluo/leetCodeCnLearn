package com.yuren.leetcodecnlearn.Q300;

import java.util.ArrayList;
import java.util.List;

public class Q282 {
    private int target;// 目标值
    private List<String> ans;// 答案
    private char[] nums;// num转数组
    private int len;// nums数组长度
    private char[] buffer; // 尝试的字符缓冲区, 结算答案用

    public List<String> addOperators(String num, int target) {
        ans = new ArrayList<>();
        this.target = target;// 设置目标
        this.len = num.length();
        this.nums = num.toCharArray();
        this.buffer = new char[len << 1];
        f(0, 0, 0, 0, '+', 0, true);
        return ans;
    }

    /**
     * 中间的结果sum, mul, num都可能超出Integer的范围, 但是最终的结果可能算回到范围内
     * <p>
     * 所以用了long, 讲道理吧... 虽然我觉得不讲道理
     *
     * @param i     处理到nums的第i位
     * @param p     缓冲区在第几位, 会将操作数i, 操作符号追加到buffer中, 用作结果
     * @param sum   到当前这个操作数, 也就是nums[j]之前所有决策的`和`,f(x)要处理sum与当前操作符op和当前操作数之间的关系
     * @param mul   sum和中的最后一位, 调用当前f(x)上一层的op和上一层的`数`
     * @param op    sum和当前数的关系
     * @param num   进入到f(x)时当前的数字是什么
     * @param first 当前是否是数字的开头
     */
    private void f(int i, int p, long sum, long mul, char op, long num, boolean first) {
        char cur = this.nums[i];// 第i位数字字符
        this.buffer[p] = cur;// 添加到第p为buffer上
        long curNum = num * 10 + (cur - '0');// 组合数字
        long curSum = 0;// 由当前f(x)产生的, 下一级的sum
        long curMul = 0;// 由当前f(x)产生的, 下一级的mul
        // op决定如何对待当前的这个`数` curNum
        if (op == '+') {
            curMul = curNum;// 例如1+2+3这个最后的+3,op是+,curNum是3, 后续可能算乘法, +3单独捞出来, 用于计算乘法
            curSum = sum + curMul;
        } else if (op == '-') {
            curMul = -curNum;// 要减去当前的数, 当前的mul是相反数, 保留符号给mul, 后续的乘法才能算对
            curSum = sum + curMul;
        } else if (op == '*') {// 要做乘法
            curMul = mul * curNum;// 就差这了
            // 把之前和中多加的mul剔除, mul与当前数乘法结合重新加给sum;
            // mul可能是个连续乘法产生的一个最终算数, 虽然是一个数, 但是buffer上可能是连续乘法
            curSum = sum - mul + curMul;
        }
        if (i == this.len - 1) {// f(x)递归来到最后一位
            if (curSum == this.target) {// 检查当前的算数结果, 因此计算curSum在这之前
                this.ans.add(new String(this.buffer, 0, p + 1));
            }
            return;
        }
        if (!first || curNum != 0) {// 第i位追加到以j开头的数字后, 保证能追加的条件
            // 这个尝试, 不加操作op, 相当于当前数字追加到j后续, j不能是0开头
            // 因为i后没有符号, 当前不结算, 沿用之前的参数, 除了curNum因为curNum中追加了当前的num[i]
            f(i + 1, p + 1, sum, mul, op, curNum, false);
        }
        // f(x)中, p放置当前字符, p+1放置尝试的符号, 后续buffer的可用位置是p+2
        // curSum : 经过f(x)对op和当前数字的处理, `和`发生了变化
        // curMul : 算数中最后一`块`的`操作符`和`数`, 后续乘法的时候需要用到
        this.buffer[p + 1] = '-';// 第i位后添加的是'-', 尝试减法
        f(i + 1, p + 2, curSum, curMul, '-', 0, true);// 插入'-',num从0重新累加
        this.buffer[p + 1] = '+';// 第i位后添加的是'+', 尝试加法
        f(i + 1, p + 2, curSum, curMul, '+', 0, true);
        this.buffer[p + 1] = '*';// 第i位后添加的是'*', 尝试乘法
        f(i + 1, p + 2, curSum, curMul, '*', 0, true);
    }
}
