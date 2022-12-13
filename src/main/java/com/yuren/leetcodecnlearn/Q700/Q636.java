package com.yuren.leetcodecnlearn.Q700;

import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-04-07 23:26
 */
public class Q636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        final int[] res = new int[n], stack = new int[logs.size() >> 1];
        int[] parsedLog;
        int prev = 0, sp = 0;
        for (String log : logs) {
            parsedLog = parse(log);
            // start
            if (parsedLog[1] == 0) {
                if (sp != 0) {
                    res[stack[sp - 1]] += parsedLog[2] - prev;
                }
                stack[sp++] = parsedLog[0];
                prev = parsedLog[2];
            } else { // end
                --sp;
                res[parsedLog[0]] += parsedLog[2] + 1 - prev;
                prev = parsedLog[2] + 1;
            }
        }
        return res;
    }

    private final int[] parse(String log) {
        // {index, type, ts}
        int i = 0;
        int index = 0;
        while (log.charAt(i) != ':') {
            index = index * 10 + (int) log.charAt(i) - 48;
            ++i;
        }
        ++i;
        int type = 0;
        if (log.charAt(i) == 'e') {
            type = 1;
        }
        while (log.charAt(i) != ':') {
            ++i;
        }
        ++i;
        int ts = 0;
        while (i < log.length()) {
            ts = ts * 10 + (int) log.charAt(i) - 48;
            ++i;
        }
        return new int[]{index, type, ts};
    }
}
