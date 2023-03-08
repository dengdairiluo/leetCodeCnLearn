package com.yuren.leetcodecnlearn.Q1200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-09 23:57
 */
public class Q1268 {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> ans = new ArrayList<>();
        int n = searchWord.length();
        int left = 0;
        int right = products.length;
        for (int i = 0; i < n; i++) {
            char c = searchWord.charAt(i);
            while (left < right && (products[left].length() <= i || products[left].charAt(i) < c)) ++left;
            while (left < right && products[right - 1].length() > i && products[right - 1].charAt(i) > c) --right;

            List<String> curr = new ArrayList<>();
            for (int j = left; j < right && j < left + 3; j++) {
                curr.add(products[j]);
            }
            ans.add(curr);
        }

        return ans;


    }
}
