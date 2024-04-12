package com.yuren.leetcodecnlearn.Q1100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-11-08 23:35
 */
public class Q1136 {
    public int minimumSemesters(int n, int[][] rels) {
        int[] refs = new int[n + 1];
        Dept[] depts = new Dept[n + 1];
        for (int[] rel : rels) {
            int px = rel[0];
            int nx = rel[1];
            refs[nx]++;
            depts[px] = new Dept(nx, depts[px]);
        }
        int[] classes = new int[n];
        int size = 0;
        for (int x = 1; x <= n; x++) {
            if (refs[x] == 0)
                classes[size++] = x;
        }
        int ix = 0;
        for (int step = 2; ; step++) {
            int size0 = size;
            for (; ix < size0; ix++) {
                int x = classes[ix];
                for (Dept d = depts[x]; d != null; d = d.next) {
                    int y = d.classId;
                    if (--refs[y] == 0) {
                        classes[size++] = y;
                    }
                }
            }
            if (size == n) {
                return step;
            }
            if (size0 == size) {
                break;
            }
        }
        return -1;
    }

    private static class Dept {
        int classId;
        Dept next;

        Dept(int classId, Dept next) {
            this.classId = classId;
            this.next = next;
        }

    }
}
