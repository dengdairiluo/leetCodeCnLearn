package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-08-13 23:37
 */
public class Q927 {
    private final int[] FALSE = new int[]{-1, -1};
    private int len;
    private int one;

    public int[] threeEqualParts(int[] arr) {
        one = 0;
        for (int num : arr) {
            if (num == 1) {
                one++;
            }
        }
        if (one % 3 != 0) {
            return FALSE;
        }
        len = arr.length;
        if (one == 0) {
            return new int[]{0, len - 1};
        }
        one = one / 3;
        int[][] section = new int[3][2];
        section[0] = this.findSection(arr, 0);
        section[1] = this.findSection(arr, section[0][1]);
        section[2] = this.findSection(arr, section[1][1]);
        // 第三个数尾部的0是最牛的0，这些0连同第三数头部的1决定了数的长度
        int len = this.len - section[2][0];
        // 不够长不行
        if (section[1][0] - section[0][0] < len || section[2][0] - section[1][0] < len) {
            return FALSE;
        }
        int start1 = section[0][0];
        int start2 = section[1][0];
        int start3 = section[2][0];
        int move = len;
        while (move > 0) {
            if (arr[start1] != arr[start2] || arr[start2] != arr[start3]) {
                return FALSE;
            }
            move--;
            start1++;
            start2++;
            start3++;
        }
        return new int[]{section[0][0] + len - 1, section[1][0] + len};
    }

    private int[] findSection(int[] arr, int start) {
        int[] section = new int[2];
        int p = start;
        int count = 1;
        while (p < len) {
            if (arr[p] == 1) {
                section[0] = p;
                break;
            }
            p++;
        }
        p++;
        while (p < len) {
            if (count == one) {
                break;
            }
            if (arr[p] == 1) {
                count++;
            }
            p++;
        }
        if (count == one) {
            section[1] = p;
        }
        return section;
    }
}
