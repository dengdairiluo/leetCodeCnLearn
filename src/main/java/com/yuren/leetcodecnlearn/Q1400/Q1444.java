package com.yuren.leetcodecnlearn.Q1400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-03-12 23:45
 */
public class Q1444 {
    public int ways(String[] pizza, int k) {
        if (pizza == null || pizza.length == 0 || pizza[0] == null || pizza[0].length() == 0 || k <= 0) {
            return 0;
        }
        int[][] map = new int[pizza.length][pizza[0].length()];

        int rightest = -1;
        //初始化k == 0 时
        for (int r = pizza.length - 1; r >= 0; r--) {
            for (int c = pizza[0].length() - 1; c >= 0; c--) {
                if (c > rightest) {
                    if (pizza[r].charAt(c) == 'A') {
                        rightest = c;
                        map[r][c] = 1;
                    } else {
                        map[r][c] = 0;
                    }
                } else {
                    map[r][c] = 1;
                }
            }
        }
        int[] horizon = getHorizon(pizza);
        int[] vertical = getVertical(pizza);
        for (int ki = 1; ki < k; ki++) {
            map = updateMap(map, horizon, vertical);
        }
        return map[0][0];
    }

    private int[][] updateMap(int[][] map, int[] horizon, int[] vertical) {
        int[][] temp = new int[map.length][map[0].length];
        int sum = 0, sub = 0;
        //求水平切割
        for (int j = 0; j < map[0].length; j++) {
            sum = 0;
            sub = 0;
            for (int i = map.length - 1; i >= 0; i--) {
                if (horizon[i] >= j) {
                    temp[i][j] = sum;
                    sub = 0;
                } else {
                    temp[i][j] = sum - sub;
                }
                sum = (sum + map[i][j]) % 1000000007;
                sub = (sub + map[i][j]);
            }
        }
        //求垂直切割
        for (int i = 0; i < map.length; i++) {
            sum = 0;
            sub = 0;
            for (int j = map[0].length - 1; j >= 0; j--) {
                if (vertical[j] >= i) {
                    //和水平切割的答案加起来
                    temp[i][j] = (temp[i][j] + sum) % 1000000007;
                    sub = 0;
                } else {
                    temp[i][j] += sum - sub;
                }
                sum = (sum + map[i][j]) % 1000000007;
                sub = (sub + map[i][j]);
            }
        }
        return temp;
    }

    private int[] getHorizon(String[] pizza) {
        int[] horizon = new int[pizza.length];
        for (int i = 0; i < pizza.length; i++) {
            horizon[i] = pizza[i].lastIndexOf('A');
        }
        return horizon;
    }

    private int[] getVertical(String[] pizza) {
        int[] vertical = new int[pizza[0].length()];
        for (int j = 0; j < pizza[0].length(); j++) {
            vertical[j] = -1;
            for (int i = pizza.length - 1; i >= 0; i--) {
                if (pizza[i].charAt(j) == 'A') {
                    vertical[j] = i;
                    break;
                }
            }
        }
        return vertical;
    }

}
