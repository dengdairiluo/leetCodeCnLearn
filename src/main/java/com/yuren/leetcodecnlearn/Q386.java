package com.yuren.leetcodecnlearn;

import java.util.ArrayList;
import java.util.List;

public class Q386 {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            dfs(n, i, list);
        }
        return list;
    }

    private void dfs(int n, int i, List<Integer> list) {
        if (i > n) {
            return;
        }
        list.add(i);
        for (int j = 0; j <= 9; j++) {
            dfs(n, i * 10 + j, list);
        }
    }


}
