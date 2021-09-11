package com.yuren.leetcodecnlearn;

import java.util.ArrayList;
import java.util.List;

public class Q93 {
    private String s;
    int n;
    private final List<String> res = new ArrayList<>();
    private final List<String> path = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        this.s = s;
        this.n = s.length();
        if (n < 4 || n > 12)
            return res;
        backtrace(0);
        return res;
    }

    public void backtrace(int idx) {
        if (path.size() == 4) {
            if (idx == n) {
                String cur = String.join(".", path);
                res.add(cur);
            }
            return;
        }
        if (idx == n) {
            return;
        }

        if (s.charAt(idx) == '0') {
            path.add("0");
            backtrace(idx + 1);
            path.remove(path.size() - 1);
        } else {
            for (int i = idx; i < n; i++) {
                int cur_num = Integer.parseInt(s.substring(idx, i + 1));
                if (0 <= cur_num && cur_num <= 255) {
                    path.add(s.substring(idx, i + 1));
                    backtrace(i + 1);
                    path.remove(path.size() - 1);
                } else {
                    break;
                }
            }
        }
    }
}
