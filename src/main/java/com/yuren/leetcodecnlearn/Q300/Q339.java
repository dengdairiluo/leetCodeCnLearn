package com.yuren.leetcodecnlearn.Q300;

import java.util.ArrayList;
import java.util.List;

public class Q339 {


    public static int depthSum(List<NestedInteger> nestedList) {
        return depthSum(nestedList, 1);
    }

    public static int depthSum(List<NestedInteger> nestedList, int depth) {
        int sum = 0;
        for (NestedInteger ni : nestedList) {
            if (ni.isIntegerFlag()) {
                sum += ni.getInteger() * depth;
            } else {
                sum += depthSum(ni.getList(), depth + 1);
            }
        }
        return sum;
    }


    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    private static class NestedInteger {
        private final boolean integerFlag;
        // Constructor initializes an empty nested list.
        private int value;
        private List<NestedInteger> list;

        public NestedInteger() {
            this.integerFlag = false;
            list = new ArrayList<>();
        }

        // Constructor initializes a single integer.
        public NestedInteger(int value) {
            this.integerFlag = true;
            this.value = value;
        }

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isIntegerFlag() {
            return integerFlag;
        }

        // Set this NestedInteger to hold a single integer.
        public void setIntegerFlag(int value) {
            this.value = value;
        }

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return value;
        }

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni) {
            list.add(ni);
        }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            return list;
        }
    }

}
