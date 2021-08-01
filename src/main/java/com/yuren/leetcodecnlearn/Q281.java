package com.yuren.leetcodecnlearn;

import java.util.ArrayList;
import java.util.List;

public class Q281 {
    private final ArrayList<Integer>[] listArr;
    private int i;
    private int j;
    private final int size;

    public Q281(List<Integer> v1, List<Integer> v2) {
        listArr = new ArrayList[2];
        listArr[0] = new ArrayList<>(v1);
        listArr[1] = new ArrayList<>(v2);
        size = Math.max(v1.size(), v2.size());
        i = v1.size() > 0 ? 0 : 1;
        j = 0;
    }

    public int next() {
        int ans = listArr[i].get(j);
        moveToNext();
        return ans;
    }

    public boolean hasNext() {
        return i < listArr.length && j < size;
    }

    private void moveToNext() {
        movePoint();
        if (j >= listArr[i].size()) {
            movePoint();
        }
    }

    private void movePoint() {
        i += 1;
        if (i == listArr.length) {
            i = 0;
            j += 1;
        }
    }
}
