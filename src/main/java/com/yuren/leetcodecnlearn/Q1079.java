package com.yuren.leetcodecnlearn;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-07-18 22:05
 */
public class Q1079 {
    public int numTilePossibilities(String tiles) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < tiles.length(); ++i) {
            if (map.get(tiles.charAt(i)) == null) {
                map.put(tiles.charAt(i), 1);
            } else {
                map.put(tiles.charAt(i), map.get(tiles.charAt(i)) + 1);
            }
        }
        int[] count = new int[map.values().size()];
        int idx = 0;
        for (int num : map.values()) {
            count[idx++] = num;
        }
        // System.out.println(Arrays.toString(count));
        // return dfs(count) - 1;

        return motherFunction(count);
    }

    int motherFunction(int[] count) {
        int ret = 0;
        // System.out.println(Arrays.toString(count));
        int[] attr = new int[count.length];
        int total = 1, length = count.length;
        for (int num : count) {
            total *= num + 1;
        }
        while (total-- > 0) {
            ++attr[length - 1];
            int subIdx = 0;
            for (subIdx = sub(count, attr); subIdx > 0; subIdx = sub(count, attr)) {
                attr[subIdx] = 0;
                ++attr[subIdx - 1];
            }
            if (subIdx == 0) {
                break;
            }
            // System.out.println(Arrays.toString(attr));
            int down = 1, sum = 0;
            for (int num : attr) {
                down *= fac(num);
                sum += num;
            }
            int value = fac(sum) / down;
            // System.out.println(value);
            ret += value;
        }
        return ret;
    }

    int sub(int[] a, int[] b) {
        for (int i = 0; i < a.length; ++i) {
            if (a[i] - b[i] < 0) {
                return i;
            }
        }
        return -1;
    }

    int fac(int n)  // 计算阶乘n!，其实可以用n!=C(n, n/2)*((n/2)!)^2，达到(logn)^2的速度，但是本题需要计算的阶乘数不大，所以用最普通的方式
    {
        if (n == 1 || n == 0) {
            return 1;
        }
        int ret = 1;
        while (n > 0) {
            ret *= n--;
        }

        return ret;
    }

    int dfs(int[] count) {
        int ret = 0;
        for (int i = 0; i < count.length; ++i) {
            if (count[i] > 0) {
                --count[i];
                ret += dfs(count);
                ++count[i];
            }
        }
        return 1 + ret;
    }

}
