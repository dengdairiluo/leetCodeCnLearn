package com.yuren.leetcodecnlearn.Q2000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-11-27 23:29
 */
public class Q2078 {
    public int maxDistance(int[] colors) {
        int length = colors.length;

        // 如果首位颜色不同直接返回
        if (colors[0] != colors[length - 1]) {
            return length - 1;
        }

        // 获取左边第一个不相同的位置
        int left = 1;
        while (colors[left] == colors[0]) {
            left += 1;
        }
        // 获取右边第一个不相同的位置
        int right = length - 2;
        while (colors[right] == colors[length - 1]) {
            right -= 1;
        }

        // 0～right 的长度 和 left～length-1 的长度取最大值
        // 因为要最大，所以不可能在中间，要么就是左边，要么就是右边
        return Math.max(right, length - 1 - left);
    }
}
