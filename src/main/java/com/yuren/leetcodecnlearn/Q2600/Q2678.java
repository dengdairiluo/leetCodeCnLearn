package com.yuren.leetcodecnlearn.Q2600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-09-24 00:58
 */
public class Q2678 {
    public int countSeniors(String[] details) {
        int ans = 0;
        for (String s : details)
            if ((s.charAt(11) - '0') * 10 + s.charAt(12) - '0' > 60)
                ans++;
        return ans;
    }
}
