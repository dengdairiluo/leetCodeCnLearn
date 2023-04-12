package com.yuren.leetcodecnlearn.Q1500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-04-12 23:23
 */
public class Q1515 {
    //答案存放处
    private double ans;
    //上、右、下、左方向数组
    private static final int[][] DI = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

    public double getMinDistSum(int[][] positions) {
        //服务中心点
        double[] centre = new double[2];
        /*先假设各个点的平均位置处是服务中心点*/
        for (int[] position : positions) {
            centre[0] += position[0];
            centre[1] += position[1];
        }
        centre[0] /= positions.length;
        centre[1] /= positions.length;
        //得到平均点到各个点的距离和
        ans = getSumDistances(centre, positions);
        /*以1为最大步长，向centre上、右、下、左查找更优解直到步长减小到0.00001*/
        changeAns(centre, positions, 1, 1e-5);
        return ans;
    }

    private void changeAns(double[] centre, int[][] positions, double test_distances, double end) {//求更优解
        if (test_distances <= end) {
            return;
        }
        int flag = 0;
        double[] newpoint = new double[2];
        for (int[] ints : DI) {
            newpoint[0] = centre[0] + test_distances * ints[0];
            newpoint[1] = centre[1] + test_distances * ints[1];
            double test = getSumDistances(newpoint, positions);
            if (test < ans) {
                centre[0] = newpoint[0];
                centre[1] = newpoint[1];
                ans = test;
                flag = 1;
                break;
            }
        }
        changeAns(centre, positions, flag == 0 ? test_distances / 2 : test_distances, end);
    }

    public double getSumDistances(double[] centre, int[][] positions) {//求centre点到各个点的距离和
        double res = 0;
        for (int[] position : positions) {
            double x = position[0] - centre[0];
            double y = position[1] - centre[1];
            res += Math.sqrt(x * x + y * y);
        }
        return res;
    }
}
