package com.yuren.leetcodecnlearn.Q1400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-03-22 23:48
 */
public class Q1472 {
    int end = -1, idx = -1;
    String[] res = new String[101];

    public Q1472(String homepage) {
        idx++;
        res[idx] = homepage;
        end++;
    }

    public void visit(String url) {
        idx++;
        res[idx] = url;
        end = idx;
    }

    public String back(int steps) {
        idx = idx > steps ? idx - steps : 0;
        return res[idx];
    }

    public String forward(int steps) {
        idx = Math.min(idx + steps, end);
        return res[idx];
    }
}
