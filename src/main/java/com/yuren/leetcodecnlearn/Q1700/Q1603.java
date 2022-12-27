package com.yuren.leetcodecnlearn.Q1700;

public class Q1603 {

    private final int[] container;

    public Q1603(int big, int medium, int small) {
        container = new int[]{big, medium, small};
    }

    public boolean addCar(int carType) {
        return container[carType - 1]-- > 0;
    }

}
