package com.yuren.leetcodecnlearn.Q1100;

import java.util.Arrays;

public class Q1086 {
    public int[][] highFive(int[][] items) {
 /*
        item[i] = [ID, score]
        res[i] = [IDi, AVG5(score)]
        按IDi升序排列
         */
        //按照ID升序排序, ID相同的按照分数降序排序
        Arrays.sort(items, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
        //代表当前已经计算了几个学生的最高分数的均分
        int index = 0;
        //遍历二维数组
        for (int i = 0; i < items.length; ) {
            //当前学生的最高五门课程的均分
            int sum = 0;
            //选取当前学生最高的五门课的分数
            //即当前ID开始的第一门到第五门课的分数, 因为相同ID的课程按照分数从高到低排列
            for (int j = i; j < i + 5; j++) {
                sum += items[j][1];
            }
            //计算5门课的分数
            sum /= 5;
            //将当前计算的学生ID以及均分放入index的位置,
            //index每次都保存下一个应该放入二维数组的位置
            //使用原始数组,从0放入, 遍历结束index表示计算了多少个学生的均分
            //当前计算的学生ID
            items[index][0] = items[i][0];
            //当前计算的学生的最高的5门课的均分
            items[index][1] = sum;
            //下一个学生应该放入二维数组的位置
            index++;
            //找到下一个学生开始的位置
            int j = i;
            //下标在范围内, 并且ID等于当前学生的ID
            while (j < items.length && items[j][0] == items[i][0]) {
                j++;
            }
            //如果已经遍历完代表当前学生为最后一个, 跳出循环
            if (j == items.length) {
                break;
            }
            //更新下一个学生的第一个位置
            i = j;

        }
        return Arrays.copyOf(items, index);

    }
}
