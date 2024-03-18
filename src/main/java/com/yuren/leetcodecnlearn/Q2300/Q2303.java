package com.yuren.leetcodecnlearn.Q2300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-03-18 22:59
 */
public class Q2303 {
    public double calculateTax(int[][] brackets, int income) {
        double totalTax = 0;
        int lower = 0;
        for (int[] bracket : brackets) {
            int upper = bracket[0], percent = bracket[1];
            int tax = (Math.min(income, upper) - lower) * percent;
            totalTax += tax;
            if (income <= upper) {
                break;
            }
            lower = upper;
        }
        return totalTax / 100.0;
    }
}
