package com.yuren.leetcodecnlearn.Q2300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-04-05 下午9:55
 */
public class Q2337 {
    public boolean canChange(String start, String target) {
        if (!start.replaceAll("_", "").equals(target.replaceAll("_", "")))
            return false;
        for (int i = 0, j = 0; i < start.length(); i++) {
            if (start.charAt(i) == '_') continue;
            while (target.charAt(j) == '_')
                j++;
            if (i != j && (start.charAt(i) == 'L') == (i < j))
                return false;
            ++j;
        }
        return true;
    }
}
