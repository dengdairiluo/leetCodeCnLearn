package com.yuren.leetcodecnlearn.Q2700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-10-26 22:11
 */
public class Q2745 {
    int[][][][] memo;
    public int longestString(int x, int y, int z) {
        memo = new int[2][51][51][51];
        return Math.max(dfs(0, x, y, z), dfs(1, x, y, z)) - 1;
    }

    // t是tail的意思，上一段结尾的字符代号，0 表示之前结尾是 'A'， 1 就是 'B'
    public int dfs(int t, int x, int y, int z) {
        if (memo[t][x][y][z] > 0) return memo[t][x][y][z];
        if (x == 0 && y == 0 && z == 0) return memo[t][x][y][z] = 1;
        if (t == 0) {
            if (y > 0) return memo[t][x][y][z] = dfs(1, x, y - 1, z) + 2;
            else return memo[t][x][y][z] = 1;
        }
        int res = 1;
        if (x > 0) res = Math.max(res, dfs(0, x - 1, y, z) + 2);
        if (z > 0) res = Math.max(res, dfs(1, x, y, z - 1) + 2);
        return memo[t][x][y][z] = res;
    }
}
