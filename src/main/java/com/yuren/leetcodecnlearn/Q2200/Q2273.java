package com.yuren.leetcodecnlearn.Q2200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-03-03 23:21
 */
public class Q2273 {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        String pre = " ";
        for (int i = 0; i < words.length; ++i) {
            char[] cs = words[i].toCharArray();
            Arrays.sort(cs);
            String s = String.valueOf(cs);
            if (i >= 1 && s.equals(pre)) continue;
            ans.add(words[i]);
            pre = s;
        }
        return ans;
    }
}
