package com.yuren.leetcodecnlearn.Q300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-12-11 23:57
 */
public class Q364 {
//    public int depthSumInverse(List<NestedInteger> nestedList) {
//        int result = 0;
//        if (nestedList == null || nestedList.size() == 0) {
//            return result;
//        }
//        Queue<NestedInteger> queue = new LinkedList<NestedInteger>();
//        Stack<Integer> levelSum = new Stack<Integer>();
//        for (int i = 0; i < nestedList.size(); i++) {
//            queue.offer(nestedList.get(i));
//        }
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            int eachLevel = 0;
//            for (int i = 0; i < size; i++) {
//                NestedInteger temp = queue.poll();
//                if (temp.isInteger()) {
//                    eachLevel += temp.getInteger();
//                } else {
//                    for (NestedInteger one : temp.getList()) {
//                        queue.offer(one);
//                    }
//                }
//            }
//            levelSum.push(eachLevel);
//        }
//        int n = 1;
//        while (!levelSum.isEmpty()) {
//            result += n * levelSum.pop();
//            n++;
//        }
//        return result;
//    }
//
//    private interface NestedInteger {
//        // Constructor initializes an empty nested list.
//        public NestedInteger();
//
//        // Constructor initializes a single integer.
//        public NestedInteger(int value);
//
//        // @return true if this NestedInteger holds a single integer, rather than a nested list.
//        public boolean isInteger();
//
//        // @return the single integer that this NestedInteger holds, if it holds a single integer
//        // Return null if this NestedInteger holds a nested list
//        public Integer getInteger();
//
//        // Set this NestedInteger to hold a single integer.
//        public void setInteger(int value);
//
//        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
//        public void add(NestedInteger ni);
//
//        // @return the nested list that this NestedInteger holds, if it holds a nested list
//        // Return empty list if this NestedInteger holds a single integer
//        public List<NestedInteger> getList();
//    }
}
