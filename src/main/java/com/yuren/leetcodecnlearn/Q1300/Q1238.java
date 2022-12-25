package com.yuren.leetcodecnlearn.Q1300;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-12-26 06:09
 */
public class Q1238 {
    /**
     * 循环的开始值
     */
    int v = 0;
    /**
     * 存放输出结果
     */
    List<Integer> res = new ArrayList<>();

    public List<Integer> circularPermutation(int n, int start) {
        // 先把开始值加进来
        res.add(start);
        v = start;
        // 当n==3时，我们的操作最大只能是 1<<2，所以传入 n - 1
        print1(n - 1);
        return res;
    }

    void print1(int n) {
        // 作为跳出条件
        if (n == 0) {
            res.add(v ^= 1);
        } else {
            print1(n - 1);
            res.add(v ^= (1 << n));
            print1(n - 1);
        }
    }
}
