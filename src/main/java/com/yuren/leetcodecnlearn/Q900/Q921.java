package com.yuren.leetcodecnlearn.Q900;

public class Q921 {
    public int minAddToMakeValid(String s) {
        int ans = 0, bal = 0;
        for (int i = 0; i < s.length(); ++i) {
            bal += s.charAt(i) == '(' ? 1 : -1;
            // It is guaranteed bal >= -1
            if (bal == -1) {
                ans++;
                bal++;
            }
        }
        return ans + bal;
    }
}
