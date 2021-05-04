package com.yuren.leetcodecnlearn;

public class Q1678 {
    public String interpret(String command) {
        int length = command.length();
        char[] charArray = command.toCharArray();
        int i = 0;
        StringBuilder builder = new StringBuilder();
        while (i < length) {
            char item = charArray[i];
            if (item == 'G') {
                builder.append("G");
                i += 1;
            } else if (item == '(' && charArray[i + 1] == ')') {
                builder.append("o");
                i += 2;
            } else if (item == '(' && charArray[i + 1] == 'a') {
                builder.append("al");
                i += 4;
            }
        }
        return builder.toString();
    }

}
