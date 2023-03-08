package com.yuren.leetcodecnlearn.Q1300;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-02-07 23:40
 */
public class Q1357 {

    private int n = 0;

    private int discount = 0;

    private Map<Integer, Integer> map = new HashMap<>();

    private final Deque<Double> deque = new ArrayDeque<>();

    public Q1357(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.discount = discount;
        for (int i = 0; i < products.length; i++) {
            map.put(products[i], prices[i]);
        }
    }

    public double getBill(int[] product, int[] amount) {
        if (deque.size() == this.n) {
            deque.clear();
        }
        double ans = 0;
        for (int i = 0; i < product.length; i++) {
            ans += map.get(product[i]) * amount[i];
        }
        deque.push(ans);
        if (deque.size() == this.n) {
            ans = ans - (discount / 100.0) * ans;
            deque.pop();
            deque.push(ans);
        }
        return deque.peek();
    }
}
