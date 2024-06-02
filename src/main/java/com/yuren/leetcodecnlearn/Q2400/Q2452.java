package com.yuren.leetcodecnlearn.Q2400;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-06-02 下午11:46
 */
public class Q2452 {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        ArrayList<String> ans = new ArrayList<>();
        for (String s : queries) {
            if (isValid(s, dictionary))
                ans.add(s);
        }
        return ans;
    }

    private boolean isValid(String s, String[] dictionary) {
        for (String word : dictionary) {
            int count = 0;
            for (int i = 0; i < word.length(); i++) {
                if (s.charAt(i) != word.charAt(i)) {
                    count++;
                    if (count == 3)
                        break;
                }
            }
            if (count <= 2)
                return true;
        }
        return false;
    }
}
