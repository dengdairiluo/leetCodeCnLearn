package com.yuren.leetcodecnlearn.Q300;

import java.util.ArrayList;
import java.util.List;

public class Q320 {
    public List<String> generateAbbreviations(String word) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), word, 0, 0);
        return ans;
    }

    // i is the current position
    // k is the count of consecutive abbreviated characters
    private void backtrack(List<String> ans, StringBuilder builder, String word, int i, int k) {
        // keep the length of builder
        int len = builder.length();
        if (i == word.length()) {
            // append the last k if non zero
            if (k != 0) builder.append(k);
            ans.add(builder.toString());
        } else {
            // the branch that word.charAt(i) is abbreviated
            backtrack(ans, builder, word, i + 1, k + 1);

            // the branch that word.charAt(i) is kept
            if (k != 0) builder.append(k);
            builder.append(word.charAt(i));
            backtrack(ans, builder, word, i + 1, 0);
        }
        // reset builder to the original state
        builder.setLength(len);
    }
}
