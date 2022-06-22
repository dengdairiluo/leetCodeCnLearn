package com.yuren.leetcodecnlearn;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-06-22 22:55
 */
public class Q809 {
    public int expressiveWords(String s, String[] words) {
        List<Character> letterList = new ArrayList<>();
        List<Integer> sizeList = new ArrayList<>();
        int length = s.length();
        char prev = s.charAt(0);
        int size = 1;
        for (int i = 1; i < length; i++) {
            char curr = s.charAt(i);
            if (curr == prev) {
                size++;
            } else {
                letterList.add(prev);
                sizeList.add(size);
                prev = curr;
                size = 1;
            }
        }
        letterList.add(prev);
        sizeList.add(size);
        int expressiveCount = 0;
        for (String word : words) {
            if (isStretchy(letterList, sizeList, word)) {
                expressiveCount++;
            }
        }
        return expressiveCount;
    }

    public boolean isStretchy(List<Character> letterList, List<Integer> sizeList, String word) {
        int groups = letterList.size();
        int groupIndex = 0;
        int length = word.length();
        char prev = word.charAt(0);
        int size = 1;
        for (int i = 1; i < length && groupIndex < groups; i++) {
            char curr = word.charAt(i);
            if (curr == prev) {
                size++;
            } else {
                char groupLetter = letterList.get(groupIndex);
                int groupSize = sizeList.get(groupIndex);
                if (prev != groupLetter) {
                    return false;
                }
                if (size > groupSize || size < groupSize && groupSize < 3) {
                    return false;
                }
                groupIndex++;
                prev = curr;
                size = 1;
            }
        }
        if (groupIndex != groups - 1) {
            return false;
        }
        char groupLetter = letterList.get(groupIndex);
        int groupSize = sizeList.get(groupIndex);
        if (prev != groupLetter) {
            return false;
        }
        if (size > groupSize || size < groupSize && groupSize < 3) {
            return false;
        }
        return true;
    }
}
