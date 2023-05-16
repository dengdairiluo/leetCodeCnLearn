package com.yuren.leetcodecnlearn.Q1600;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-05-16 23:35
 */
public class Q1610 {
    public static int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        // 思路，计算每个point与location形成的线，与x轴成的角度，存入一个list中
        List<Double> degreesList = new ArrayList<>();
        int base = 0;
        // 再滑动一个窗口，计算指定出指定度数范围内，可以存在最多的点
        for (List<Integer> point : points) {
            int x = point.get(0) - location.get(0);
            int y = point.get(1) - location.get(1);
            // 把location想象成是四个象限的0，0点来处理
            // 一象限 0~90度
            // 二象限 90~180度
            // 三象限 180~270度
            // 四象限 270~360度
            if (x == 0 && y == 0) {
                // point和location重叠
                base++;
            } else if (x == 0) {
                // x 等于0
                degreesList.add(y > 0 ? 90D : 270D);
            } else if (y == 0) {
                // y 等于0， x为正数
                degreesList.add(x > 0 ? 0D : 180D);
            } else if (x < 0 && y < 0) {
                // x y 都小于0 三象限
                degreesList.add(180D + toDegrees(-y, -x));
            } else if (x < 0) {
                // x 小于0， y 大于0 二象限
                degreesList.add(180D - toDegrees(y, -x));
            } else if (y < 0) {
                // x 大于0， y 小于0 四象限
                degreesList.add(360D - toDegrees(-y, x));
            } else {
                // x y 都大于0 一象限
                degreesList.add(toDegrees(y, x));
            }
        }
        // 转数组，排序。
        double[] arr = new double[degreesList.size()];
        for (int i = 0; i < degreesList.size(); i++) {
            arr[i] = degreesList.get(i);
        }
        Arrays.sort(arr);
        // 原arr数组排序后，再新增到新数组里面，因为要做的是一个环的滑动窗口，2和360度只差2度
        double[] newArr = new double[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
            newArr[i + arr.length] = arr[i] + 360D;
        }
        int start = 0;
        for (double degrees : newArr) {
            if (degrees - newArr[start] > angle) {
                start++;
            }
        }
        return base + newArr.length - start;
    }

    static double toDegrees(double y, double x) {
        // y 为对边，x为邻边
        // 返回度数
        return Math.toDegrees(Math.atan(y / x));
    }
}
