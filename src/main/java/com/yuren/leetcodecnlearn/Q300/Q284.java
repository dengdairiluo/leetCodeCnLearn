package com.yuren.leetcodecnlearn.Q300;

import java.util.Iterator;

public class Q284 implements Iterator<Integer> {
    private final Iterator<Integer> iter;
    Integer next;

    public Q284(Iterator<Integer> iterator) {
        // initialize any member here.
        iter = iterator;
        next = iter.hasNext() ? iter.next() : null; // if the init iterator is empty
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer tmp = next;
        next = iter.hasNext() ? iter.next() : null;
        return tmp;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

}
