package com.yuren.leetcodecnlearn.Q1100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-10-04 23:29
 */
public class Q1053 {
    public int[] prevPermOpt1(int[] arr) {
        int len = arr.length;
        int curMax = -1;
        int index = -1;
        boolean hasResult = false;
        for (int i = len - 2; i >= 0; i--) {
            // 此处逆序，需要移动arr[i]
            if (arr[i + 1] < arr[i]) {
                // 寻找与 arr[i] 交换的位置
                for (int j = i + 1; j < len; j++) {
                    // 必须满足 arr[i] > arr[j]，否则不能满足交换后的字典序小于原始字典序
                    if (arr[i] > arr[j]) {
                        hasResult = true;
                        if (arr[j] > curMax) {
                            curMax = arr[j];
                            index = j;
                        }
                    }
                }
                if (hasResult) {
                    int tmp = arr[i];
                    arr[i] = arr[index];
                    arr[index] = tmp;
                    return arr;
                }
            }
        }
        return arr;
    }
}
