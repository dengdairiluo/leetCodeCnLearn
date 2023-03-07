package com.yuren.leetcodecnlearn.Q900;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-08-16 23:46
 */
public class Q937 {
    private static class Log {
        int type, idx;
        String ori, sign, content;

        Log(String s, int idx) {
            this.idx = idx;
            int n = s.length(), i = 0;
            while (i < n && s.charAt(i) != ' ') {
                i++;
            }
            sign = s.substring(0, i);
            content = s.substring(i + 1);
            ori = s;
            type = Character.isDigit(content.charAt(0)) ? 1 : 0;
        }
    }

    public String[] reorderLogFiles(String[] logs) {
        int n = logs.length;
        List<Log> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Log(logs[i], i));
        }
        list.sort((a, b) -> {
            if (a.type != b.type) {
                return a.type - b.type;
            }
            if (a.type == 1) {
                return a.idx - b.idx;
            }
            return !a.content.equals(b.content) ? a.content.compareTo(b.content) : a.sign.compareTo(b.sign);
        });
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            ans[i] = list.get(i).ori;
        }
        return ans;
    }
}
