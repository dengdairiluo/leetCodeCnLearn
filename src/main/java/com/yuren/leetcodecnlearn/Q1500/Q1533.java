package com.yuren.leetcodecnlearn.Q1500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-04-15 23:47
 */
public class Q1533 {
    public int getIndex(ArrayReader reader) {
        // 获取数组长度
        int length = reader.length();
        // 左右两边各有length / 2个数 左边[0, length /2 -1], 右边 [length - length / 2, length - 1]
        return help(0, length / 2 - 1, length - length / 2, length - 1, reader);
    }

    private int help(int l, int r, int x, int y, ArrayReader reader) {
        int value = reader.compareSub(l, r, x, y);
        // 说明在左边
        if (value > 0) {
            // 说明只有1个 不需要在分割了
            if (l == r) {
                return l;
            }
            // 将[l, r]继续
            int length = r - l + 1;
            return help(l, l + length / 2 - 1, r - length / 2 + 1, r, reader);
        }
        // 说明在右边
        if (value < 0) {
            // 说明只有1个 不需要在分割了
            if (x == y) {
                return x;
            }
            // 将[x, y]继续
            int length = y - x + 1;
            return help(x, x + length / 2 - 1, y - length / 2 + 1, y, reader);
        }
        // 左右两边相等 即[l,r] [x,y]相等 则取r + 1 也等于x - 1
        return r + 1;
    }


    private static class ArrayReader {
        /**
         * Compares the sum of arr[l..r] with the sum of arr[x..y]
         * return 1 if sum(arr[l..r]) > sum(arr[x..y])
         * return 0 if sum(arr[l..r]) == sum(arr[x..y])
         * return -1 if sum(arr[l..r]) < sum(arr[x..y])
         */
        public int compareSub(int l, int r, int x, int y) {
            return 0;
        }

        // Returns the length of the array
        public int length() {
            return 0;
        }
    }
}
