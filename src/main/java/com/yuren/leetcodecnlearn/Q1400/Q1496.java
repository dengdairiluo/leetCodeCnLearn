package com.yuren.leetcodecnlearn.Q1400;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-03-30 23:39
 */
public class Q1496 {
    public boolean isPathCrossing(String path) {
        Set<Integer> vis = new HashSet<>();

        int x = 0, y = 0;
        vis.add(getHash(x, y));

        int length = path.length();
        for (int i = 0; i < length; i++) {
            char dir = path.charAt(i);
            switch (dir) {
                case 'N':
                    --x;
                    break;
                case 'S':
                    ++x;
                    break;
                case 'W':
                    --y;
                    break;
                case 'E':
                    ++y;
                    break;
                default:
                    break;
            }
            int hashValue = getHash(x, y);
            if (!vis.add(hashValue)) {
                return true;
            }
        }

        return false;
    }

    public int getHash(int x, int y) {
        return x * 20001 + y;
    }
}
