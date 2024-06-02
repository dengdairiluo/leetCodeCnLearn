package com.yuren.leetcodecnlearn.Q2400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-06-02 下午11:39
 */
public class Q2451 {
    public boolean compare(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public int[] gerArr(String words) {
        int[] arr = new int[words.length() - 1];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = words.charAt(i + 1) - words.charAt(i);
        }

        return arr;
    }

    public String oddString(String[] words) {
        int[] tempArr1;
        int[] tempArr2;
        int[] tempArr3;

        for (int i = 0; i < words.length; i++) {
            tempArr1 = gerArr(words[i]);
            for (int j = i + 1; j < words.length; j++) {
                tempArr2 = gerArr(words[j]);
                if (compare(tempArr1, tempArr2)) {
                    continue;
                } else if (j > 1) {
                    return words[j];
                } else {
                    tempArr3 = gerArr(words[j + 1]);
                    if (compare(tempArr1, tempArr3)) {
                        return words[j];
                    }
                    return words[i];
                }
            }
        }

        return "";
    }
}
