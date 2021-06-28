package com.yuren.leetcodecnlearn;

public class Q1910 {
    public String removeOccurrences(String s, String part) {
        if (!s.contains(part)) {
            return s;
        }
        return removeOccurrences(s.replace(part, ""), part);
    }
}
