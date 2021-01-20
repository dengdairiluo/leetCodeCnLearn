package com.yuren.leetcodecnlearn;

public class Q1281 {

    public static int subtractProductAndSum(int n) {

        int sum = 0;
        int multi = 1;
        while (n > 0) {
            int a = n % 10;
            sum += a;
            multi*= a;
            n /= 10;
        }
        return multi - sum;
    }

    public static void main(String[] args) {
        System.out.println(subtractProductAndSum(234));
        System.out.println(subtractProductAndSum(4421));
    }
}
