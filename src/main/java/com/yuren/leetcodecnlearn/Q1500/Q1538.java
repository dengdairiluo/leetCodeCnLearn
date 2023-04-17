package com.yuren.leetcodecnlearn.Q1500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-04-17 23:52
 */
public class Q1538 {
    public int guessMajority(ArrayReader reader) {

        int n = reader.length();

        int start = reader.query(0, 1, 2, 3);

        int i1 = 3;
        int i2 = -1;
        int group1 = 1, group2 = 0;

        //假设 index3 是group1

        for (int i = 4; i < n; i++) {
            int q = reader.query(0, 1, 2, i);
            if (q == start) {
                group1++;
            } else {
                i2 = i;
                group2++;
            }
        }

        //再看前面3个值

        int sudo = reader.query(0, 1, 2, 4);
        //test 0
        if (reader.query(1, 2, 3, 4) == sudo) {
            group1++;
        } else {
            group2++;
            i2 = 0;
        }

        //test 2
        if (reader.query(0, 1, 3, 4) == sudo) {
            group1++;
        } else {
            group2++;
            i2 = 2;
        }

        //test1
        if (reader.query(0, 2, 3, 4) == sudo) {
            group1++;
        } else {
            group2++;
            i2 = 1;
        }

        if (group1 == group2) {
            return -1;
        }
        if (group1 > group2) {
            return i1;
        }
        return i2;

    }

    private static class ArrayReader {
        // Compares 4 different elements in the array
        // return 4 if the values of the 4 elements are the same (0 or 1).
        // return 2 if three elements have a value equal to 0 and one element has value equal to 1 or vice versa.
        // return 0 : if two element have a value equal to 0 and two elements have a value equal to 1.
        public int query(int a, int b, int c, int d) {
            return 0;
        }

        // Returns the length of the array
        public int length() {
            return 0;
        }
    }

    ;
}
