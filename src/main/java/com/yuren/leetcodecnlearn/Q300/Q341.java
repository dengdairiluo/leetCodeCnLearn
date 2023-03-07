package com.yuren.leetcodecnlearn.Q300;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Q341 implements Iterator<Integer> {
    private final List<Integer> vals;
    private final Iterator<Integer> cur;

    public Q341(List<Q341> nestedList) {
        vals = new ArrayList<>();
        dfs(nestedList);
        cur = vals.iterator();
    }

    @Override
    public Integer next() {
        return cur.next();
    }

    @Override
    public boolean hasNext() {
        return cur.hasNext();
    }

    /**
     * 默认方法1
     *
     * @return
     */
    public boolean isInteger() {
        return false;
    }

    /**
     * 默认方法2
     *
     * @return
     */
    public Integer getInteger() {
        return -1;
    }

    /**
     * 默认方法3
     *
     * @return
     */
    public List<Q341> getList() {
        return new ArrayList<>();
    }

    private void dfs(List<Q341> nestedList) {
        for (Q341 nest : nestedList) {
            if (nest.isInteger()) {
                vals.add(nest.getInteger());
            } else {
                dfs(nest.getList());
            }
        }
    }
}
