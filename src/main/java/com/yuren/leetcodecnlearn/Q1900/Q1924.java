package com.yuren.leetcodecnlearn.Q1900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-09-13 23:30
 */
public class Q1924 {
    public double[] outerTrees(int[][] trees) {
        if (trees.length > 1) {
            for (int i = 0; i < trees.length; i++) {
                int pos = 0;
                int[] temp = trees[i];
                trees[i] = trees[pos];
                trees[pos] = temp;
            }
        }
        double r = 0;
        double centerx = trees[0][0];
        double centery = trees[0][1];
        for (int i = 0; i < trees.length; i++) {
            if (dis(trees[i][0], centerx, trees[i][1], centery) > r * r) {
                centerx = trees[i][0];
                centery = trees[i][1];
                r = 0;
                for (int j = 0; j < i; j++) {
                    if (dis(trees[j][0], centerx, trees[j][1], centery) > r * r) {
                        centerx = ((double) (trees[i][0] + trees[j][0])) / 2.0;
                        centery = ((double) (trees[i][1] + trees[j][1])) / 2.0;
                        r = Math.sqrt(dis(trees[j][0], centerx, trees[j][1], centery));
                        for (int k = 0; k < j; k++) {
                            if (dis(trees[k][0], centerx, trees[k][1], centery) > r * r) {
                                double[] tmp = getCircle(trees, i, j, k);
                                centerx = tmp[0];
                                centery = tmp[1];
                                r = tmp[2];
                            }
                        }
                    }
                }
            }
        }
        return new double[]{centerx, centery, r};
    }

    double dis(double x1, double x2, double y1, double y2) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }

    double[] getCircle(int[][] trees, int idx1, int idx2, int idx3) {
        double[] ans = new double[3];
        double P1 = trees[idx1][1] - trees[idx3][1];
        double P2 = trees[idx1][1] - trees[idx2][1];
        double Q1 = trees[idx1][0] - trees[idx3][0];
        double Q2 = trees[idx1][0] - trees[idx2][0];
        double A = (trees[idx1][0] * trees[idx1][0] - trees[idx2][0] * trees[idx2][0]) + (trees[idx1][1] * trees[idx1][1] - trees[idx2][1] * trees[idx2][1]);
        double B = (trees[idx1][0] * trees[idx1][0] - trees[idx3][0] * trees[idx3][0]) + (trees[idx1][1] * trees[idx1][1] - trees[idx3][1] * trees[idx3][1]);
        double C = 2 * (trees[idx1][0] - trees[idx2][0]) * (trees[idx1][1] - trees[idx3][1]) - 2 * (trees[idx1][0] - trees[idx3][0]) * (trees[idx1][1] - trees[idx2][1]);
        double x = (P1 * A - P2 * B) / C;
        double y = (Q2 * B - Q1 * A) / C;
        return new double[]{x, y, Math.sqrt(dis(trees[idx1][0], x, trees[idx1][1], y))};
    }
}
