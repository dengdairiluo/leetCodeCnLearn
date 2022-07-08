package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-07-08 23:39
 */
public class Q845 {
    public int longestMountain(int[] arr) {
        //长度不够的，直接排除
        if (arr.length < 3) return 0;
        int max = 0;
        //依次从下标1，到下标len-2，当做中心点左右扩散，求出宽度。
        for (int i = 1; i < arr.length - 1; i++) {
            int left = i - 1, right = i + 1;
            //如果不是左右的最高点，直接结束，进入下一个循环
            if (arr[left] >= arr[i] || arr[right] >= arr[i]) continue;
            //山脉的最左侧下标(最终的left要比山脉的左侧下标小1)
            while (left >= 0 && arr[left] < arr[left + 1]) {
                left--;
            }
            //山脉的最右侧下标(最终的right要比山脉的右侧下标大1)
            while (right < arr.length && arr[right] < arr[right - 1]) {
                right++;
            }
            //比较，保存最大山脉长度
            max = Math.max(max, right - left - 1);
        }
        return max;
    }
}
