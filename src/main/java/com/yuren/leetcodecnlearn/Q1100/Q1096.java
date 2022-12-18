package com.yuren.leetcodecnlearn.Q1100;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-10-24 23:50
 */
public class Q1096 {
    private static class MySet {
        HashSet<String> vals;

        public MySet() {
            vals = new HashSet<>();
        }

        public MySet(HashSet<String> v) {
            vals = v;
        }

        public void union(MySet another) {
            vals.addAll(another.vals);
        }

        public void multi(MySet another) {
            if (another.vals.size() == 0) {
                return;
            }
            if (vals.size() == 0) {
                vals = another.vals;
                return;
            }
            HashSet<String> newVals = new HashSet<>(vals.size() * another.vals.size());
            for (String str1 : vals) {
                for (String val : another.vals) {
                    newVals.add(str1 + val);
                }
            }
            vals = newVals;
        }

        public void multi(String str) {
            if (str == null || str.length() == 0) {
                return;
            }
            if (vals.size() == 0) {
                vals.add(str);
                return;
            }
            Iterator<String> it = vals.iterator();
            HashSet<String> newVals = new HashSet<>(vals.size());
            while (it.hasNext()) {
                newVals.add(it.next() + str);
            }
            vals = newVals;
        }
    }

    public List<String> braceExpansionII(String expression) {
        MySet ret = braceExpansionIIInner(expression);
        String[] rett = ret.vals.toArray(new String[0]);
        Arrays.sort(rett);
        return Arrays.asList(rett);
    }

    private MySet braceExpansionIIInner(String expression) {
        MySet ret = new MySet();
        Stack<Integer> st = new Stack<>();

        int lastComma = -1, l = -1;
        st.push(-1);
        MySet pre = new MySet();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '{') {
                if (st.peek() == -1 && lastComma < i - 1 && l < i - 1) {
                    pre.multi(expression.substring(l + 1, i));
                    l = i - 1;
                }
                st.push(i);
            } else if (c == '}') {
                //处理一个花括号
                int hl = st.pop();
                if (st.peek() == -1) {
                    pre.multi(braceExpansionIIInner(expression.substring(hl + 1, i)));
                    l = i;
                }
            } else if (c == ',') {
                if (st.peek() == -1) {
                    if (l < i - 1) {
                        pre.multi(expression.substring(l + 1, i));
                    }
                    ret.union(pre);
                    pre = new MySet();
                    lastComma = i;
                    l = i;
                }
            }
        }
        if (l < expression.length() - 1) {
            //最后没处理完的字符串
            pre.multi(expression.substring(l + 1, expression.length()));
        }
        ret.union(pre);
        return ret;
    }
}
