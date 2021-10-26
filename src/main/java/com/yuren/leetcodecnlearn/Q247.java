package com.yuren.leetcodecnlearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q247 {
    public List<String> findStrobogrammatic(int n) {
        if (n <= 0) return new ArrayList<>();
        if (n == 1) return Arrays.asList("0", "1", "8");
        if (n == 2) return Arrays.asList("11", "69", "88", "96");
        // arr[n] 表示长度为 n 的所有中心对称数
        List<String>[] arr = new List[n + 1];
        arr[1] = Arrays.asList("0", "1", "8");
        arr[2] = Arrays.asList("00", "11", "69", "88", "96");
        for (int i = 3; i <= n; i++) {
            // 随着 i 不断地增长，我们只需要在长度为 i-2 的中心对称数两边添加 11，69，88，96 即可。
            List<String> tmpList = new ArrayList<>();
            for (String s : arr[i - 2]) {
                if (i != n) {
                    tmpList.add("0" + s + "0");
                }
                tmpList.add("1" + s + "1");
                tmpList.add("6" + s + "9");
                tmpList.add("8" + s + "8");
                tmpList.add("9" + s + "6");
            }
            arr[i] = tmpList;
        }
        return arr[n];
    }
}
