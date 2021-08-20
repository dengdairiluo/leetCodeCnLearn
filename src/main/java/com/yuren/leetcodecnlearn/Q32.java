package com.yuren.leetcodecnlearn;

import java.util.Stack;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-08-20 23:28
 */
public class Q32 {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<Integer>();
        int ans = 0;
        for(int i = 0 ,start = 0;i < s.length();i ++)
        {
            if( s.charAt(i) == '(') {
                st.add(i);
            } else
            {
                if(!st.isEmpty())
                {
                    st.pop();
                    if(st.isEmpty()) {
                        ans = Math.max(ans,i - start + 1);
                    } else {
                        ans = Math.max(ans,i - st.peek());
                    }
                }
                else {
                    start = i + 1;
                }
            }
        }
        return ans;
    }
}
