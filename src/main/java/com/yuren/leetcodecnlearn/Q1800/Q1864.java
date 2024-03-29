package com.yuren.leetcodecnlearn.Q1800;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-08-19 19:47
 */
public class Q1864 {
    public int minSwaps(String s) {
        char[] arr = s.toCharArray();
        int num1 = 0, num0 = 0;
        for (char c : arr) {
            if (c == '0') num0++;
            else num1++;
        }
        if (Math.abs(num0 - num1) > 1) return -1;
        if (num0 > num1) {
            // 0开头
            return getSum(arr, '1');
        } else if (num1 > num0) {
            // 1开头
            return getSum(arr, '0');
        } else {
            // 取0开头和1开头的min值
            return Math.min(getSum(arr, '0'), getSum(arr, '1'));
        }
    }

    // even: 偶数位需要替换的字符
// 若是'1'开始，那么当偶数位为'0'时需要替换
// 若是'0'开始，那么当偶数位为'1'时需要替换
    private int getSum(char[] arr, char even) {
        // 从哪个下标开始替换
        // 注：假设偶数都为'1' 则 需要把奇数位的'1'和偶数位的'0'进行交换
        int index = 1;
        int res = 0;
        // 注意：i+=2
        for (int i = 0; i < arr.length; i += 2) {
            if (arr[i] == even) {
                while (index < arr.length && arr[index] == even) {
                    // 注意：index+=2
                    index += 2;
                }
                res++;
                /*
                 * 假设在这里替换了，那么替换完需要index需要来到index+2的地方 方便下一次循环
                 * 因为题目中只是要交换次数 而不需要返回替换完成的交替字符串 那么交换过程可以省略
                 * 只需要用两个下标来记录'交换到哪'即可
                 * */
                index += 2;
            }
        }
        return res;
    }
}
