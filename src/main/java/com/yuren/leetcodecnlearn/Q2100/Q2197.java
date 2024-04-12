package com.yuren.leetcodecnlearn.Q2100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-01-25 23:39
 */
public class Q2197 {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> resultList = new ArrayList<>();
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int gcd = getGcd(temp, num);
            if (gcd == 1) {
                int j = resultList.size() - 1;
                while (j >= 0) {
                    int listTail = resultList.get(j);
                    int gcd1 = getGcd(temp, listTail);
                    if (gcd1 == 1) {
                        break;
                    } else {
                        temp = getLcm(temp, listTail, gcd1);
                        resultList.remove(j);
                        j--;
                    }
                }
                resultList.add(temp);
                temp = num;
            } else {
                temp = getLcm(temp, num, gcd);
            }
        }
        int j = resultList.size() - 1;
        while (j >= 0) {
            int listTail = resultList.get(j);
            int gcd1 = getGcd(temp, listTail);
            if (gcd1 == 1) {
                break;
            } else {
                temp = getLcm(temp, listTail, gcd1);
                resultList.remove(j);
                j--;
            }
        }
        resultList.add(temp);
        return resultList;
    }

    private int getLcm(int n, int m, int gcd) {
        return n / gcd * m;
    }

    private int getGcd(int n, int m) {
        while (m > 0) {
            int temp = m;
            m = n % m;
            n = temp;
        }
        return n;
    }
}
