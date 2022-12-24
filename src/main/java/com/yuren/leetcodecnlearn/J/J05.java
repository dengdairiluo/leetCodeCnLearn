package com.yuren.leetcodecnlearn.J;

public class J05 {
    private static String replaceSpace1(String s) {
        return s.replaceAll(" ", "%20");
    }

    private static String replaceSpace2(String s) {
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                builder.append("%20");
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    private static String replaceSpace3(String s) {
        return s.replace(" ", "%20");
    }

    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace1(s));
        System.out.println(replaceSpace2(s));
        System.out.println(replaceSpace3(s));

    }
}
