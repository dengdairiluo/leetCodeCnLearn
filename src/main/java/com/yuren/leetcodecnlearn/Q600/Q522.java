package com.yuren.leetcodecnlearn.Q600;

public class Q522 {
    public int findLusLength(String[] args) {
        if (args.length == 0) return -1;
        if (args.length == 1) return args[0].length();
        sortStringArrayByLength(args);
        for (int index = 0; index < args.length; index++) {
            int result = checkStrIsUnique(args, index);
            if (result != -1) return result;
        }
        return -1;
    }

    private int checkStrIsUnique(String[] args, int index) {
        String tarStr = args[index];
        for (int i = 0; i < args.length; i++) {
            if (i == index) continue;
            if (isSubsequence(args[i], tarStr))
                return -1;
        }
        return tarStr.length();
    }

    private boolean isSubsequence(String str1, String str2) {
        int j = 0;
        for (int i = 0; i < str1.length() && j < str2.length(); i++) {
            if (str1.charAt(i) == str2.charAt(j)) j++;
        }
        return str2.length() == j;
    }


    private void sortStringArrayByLength(String[] strArray) {
        for (int unsorted = 1; unsorted < strArray.length; unsorted++) {
            for (int sorted = unsorted - 1; sorted > -1; sorted--) {
                if (strArray[sorted + 1].length() > strArray[sorted].length()) {
                    swap(strArray, sorted + 1, sorted);
                }
            }
        }
    }

    private void swap(String[] strArray, int unsorted, int sorted) {
        String temp = strArray[unsorted];
        strArray[unsorted] = strArray[sorted];
        strArray[sorted] = temp;
    }
}
