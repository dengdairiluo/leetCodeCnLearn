package com.yuren.leetcodecnlearn.Q2100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-01-19 23:28
 */
public class Q2184 {
    int mod = (int) 1e9 + 7;
    boolean hasBrick[] = new boolean[12];
    int width;

    public int buildWall(int height, int width, int[] bricks) {
        //分割点：[1,width-1]，最多512种，把所有可能的分割点用二进制表示，相邻的进行异或等于和
        this.width = width;
        for (int brick : bricks) {
            hasBrick[brick] = true;
        }
        //储存可能的分割的二进制表示
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < (1 << width); i++) {
            if (canSplit(i)) {
                list.add(i);
            }
        }
        boolean canBeNeighbor[][] = new boolean[list.size()][list.size()];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                int a = list.get(i), b = list.get(j);
                if (a + b == (a ^ b)) {
                    canBeNeighbor[j][i] = true;
                }
            }
        }
        List<Integer>[] lastLayer = new List[list.size()];
        for (int i = 0; i < list.size(); i++) {
            lastLayer[i] = new ArrayList<>();
            for (int j = 0; j < list.size(); j++) {
                if (canBeNeighbor[i][j]) {
                    lastLayer[i].add(j);
                }
            }
        }
        int[][] brickGather = new int[height][list.size()];
        Arrays.fill(brickGather[0], 1);
        for (int i = 1; i < height; i++) {
            for (int j = 0; j < list.size(); j++) {
                for (int k = 0; k < lastLayer[j].size(); k++) {
                    brickGather[i][j] = (brickGather[i][j] + brickGather[i - 1][lastLayer[j].get(k)]) % mod;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < list.size(); i++) {
            ans = (ans + brickGather[height - 1][i]) % mod;
        }
        return ans;
    }

    public boolean canSplit(int k) {
        int l = 0;
        for (int i = 0; i < width; i++) {
            if ((k & (1 << i)) != 0) {
                if (!hasBrick[i - l]) {
                    return false;
                }
                l = i;
            }
        }
        return hasBrick[width - l];
    }
}
