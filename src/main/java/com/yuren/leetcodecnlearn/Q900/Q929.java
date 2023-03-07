package com.yuren.leetcodecnlearn.Q900;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-08-13 23:41
 */
public class Q929 {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String s : emails) {
            StringBuilder sb = new StringBuilder();
            int n = s.length(), i = 0;
            boolean ok = true;
            while (i < n) {
                char c = s.charAt(i);
                if (c == '@') {
                    break;
                }
                if (c == '.') {
                    ++i;
                    continue;
                }
                if (c == '+') {
                    ok = false;
                }
                if (ok) {
                    sb.append(c);
                }
                i++;
            }
            set.add(sb.append(s.substring(i)).toString());
        }
        return set.size();
    }
}
