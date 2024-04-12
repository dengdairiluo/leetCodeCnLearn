package com.yuren.leetcodecnlearn.Q1400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-03-29 23:37
 */
public class Q1494 {
    private static boolean loop1(int[] preOrderList, int[] jie, int preIndex, int j, int k, int[] levelCount, int totalRel, int[][][] relMap) {
        int currentKe = preOrderList[preIndex];
        outer:
        for (int i = 1; i <= j; i++) {
            //校验层上的数量上限
            if (levelCount[i - 1] >= k) {
                continue;
            }

            //遍历校验依赖关系,假设有依赖关系不满足则进行下一次循环

            int currentKeTmp = 1 << (currentKe + 1);
            if ((totalRel & currentKeTmp) == currentKeTmp) {
                //当前课程存在约束需要判断
                for (int i1 : relMap[currentKe][0]) {
                    if (i1 == 0) {
                        break;
                    }
                    if (jie[i1 - 1] != 0 && jie[i1 - 1] >= i) {
                        continue outer;
                    }
                }
                for (int i1 : relMap[currentKe][1]) {
                    if (i1 == 0) {
                        break;
                    }
                    if (jie[i1 - 1] != 0 && jie[i1 - 1] <= i) {
                        continue outer;
                    }
                }
            }

            jie[currentKe] = i;
            levelCount[i - 1]++;
            if (jie.length == preIndex + 1) {
                //最底层
                // System.out.println(Arrays.toString(jie));
                return true;
            } else {
                boolean b = loop1(preOrderList, jie, preIndex + 1, j, k, levelCount, totalRel, relMap);
                if (!b) {
                    jie[currentKe] = 0;
                    levelCount[i - 1]--;
                } else {
                    return b;
                }
            }

        }
        return false;
    }

    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        //从最少层朝上试探
        int level = Math.round((float) n / k);

        int totalRel = 0;

        int tempLevel = 0;
        int[] tempRel = new int[n];
        //二维数组，第二维第一个元素小于1维元素，第二个元素大于登月1维元素
        int[][][] relMap = new int[n][2][n];
        for (int[] ints : relations) {
            totalRel |= 1 << ints[0];
            totalRel |= 1 << ints[1];
            int[] a = relMap[ints[1] - 1][0];
            for (int i = 0; i < n; i++) {
                if (a[i] == 0) {
                    a[i] = ints[0];
                    break;
                }
            }
            int[] b = relMap[ints[0] - 1][1];
            for (int j = 0; j < n; j++) {
                if (b[j] == 0) {
                    b[j] = ints[1];
                    break;
                }
            }
        }
        //粗排
        for (int i = 0; i < n; i++) {
            ;
            int[] a = relMap[i][1];
            for (int j : a) {
                if (j == 0) {
                    break;
                } else {
                    if (tempRel[j - 1] <= tempRel[i]) {
                        tempRel[j - 1] = tempRel[i] + 1;
                        if (tempRel[j - 1] > tempLevel) {
                            tempLevel = tempRel[j - 1];
                        }
                    }
                }
            }
        }
        int tmpIdx = 0;
        int[] preOrderList = new int[n];
        for (int p = 0; p <= tempLevel; p++) {
            for (int i = 0; i < tempRel.length; i++) {
                if (tempRel[i] == p) {
                    preOrderList[tmpIdx++] = i;
                }
            }
        }

        for (int l = Math.max(level, tempLevel); l <= n; l++) {
            int[] jie = new int[n];
            int[] levelCount = new int[l];
            boolean b = loop1(preOrderList, jie, 0, l, k, levelCount, totalRel, relMap);
            if (b) {
                // System.out.println("解为：" + l);
                return l;
            }

        }
        return 1;
    }
}
