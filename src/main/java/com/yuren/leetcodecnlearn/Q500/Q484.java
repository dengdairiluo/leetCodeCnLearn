package com.yuren.leetcodecnlearn.Q500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-01-29 23:46
 */
public class Q484 {
    public void rev(int[] ints, int start, int end) {
        if (ints.length == 0 || ints.length == 1) {
            return;
        } else {

            for (int i = start, index = 0; i < (start + end) / 2 + 1; i++, index++) { //前后交换
                int temp = ints[i];
                ints[i] = ints[end - index];
                ints[end - index] = temp;
            }
        }

    }

    public int[] findPermutation(String s) {
        if (s.isEmpty()) {
            //字符串为空
            return new int[0];
        }
        //转化字符数组
        char[] chs = s.toCharArray();
        //保存结果，长度+1   1，2，3，4
        int[] ints = new int[chs.length + 1];
        for (int i = 0; i < ints.length; i++) {
            //初始化
            ints[i] = i + 1;
        }
        //循环每个字符 DI
        for (int i = 0; i < chs.length; i++) {
            int index = i;
            if (chs[index] == 'D') {
                //DDD
                while (index < chs.length && chs[index] == 'D') {
                    index++;
                }
                //123
                //213
                //反转
                rev(ints, i, index);
                //循环
                i = index - 1;


            }

        }

        return ints;


    }
}
