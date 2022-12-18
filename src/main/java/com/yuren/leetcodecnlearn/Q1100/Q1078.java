package com.yuren.leetcodecnlearn.Q1100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-10-16 23:32
 */
public class Q1078 {
    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        List<String> list = new ArrayList<>();
        for (int i = 2; i < words.length; i++) {
            if (words[i - 2].equals(first) && words[i - 1].equals(second)) {
                list.add(words[i]);
            }
        }
        int size = list.size();
        String[] ret = new String[size];
        for (int i = 0; i < size; i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
}
