package com.yuren.leetcodecnlearn.Q900;

public class Q944 {
    public int minDeletionSize(String[] strs) {
        int ans = 0;
        for (int c = 0; c < strs[0].length(); ++c)
            for (int r = 0; r < strs.length - 1; ++r)
                if (strs[r].charAt(c) > strs[r + 1].charAt(c)) {
                    ans++;
                    break;
                }

        return ans;

    }
}
