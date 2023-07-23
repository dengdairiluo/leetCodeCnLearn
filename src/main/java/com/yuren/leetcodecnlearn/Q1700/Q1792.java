package com.yuren.leetcodecnlearn.Q1700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-07-23 22:46
 */
public class Q1792 {
    /**
     * 小顶堆
     */
    private static final ClassInfo[] QUEUE = new ClassInfo[100000];
    /**
     * 堆大小
     */
    private int size;

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // 将通过率低于100%的班级堆积在数组前端
        size = classes.length;
        for (int i = 0; i < size; i++) {
            while (classes[i][0] == classes[i][1] && --size != i) {
                classes[i] = classes[size];
            }
        }
        if (size <= 1) {
            if (size == 0) {
                // 所有班级通过率都为100%
                return 1;
            }

            // 只有一个班级通过率低于100%
            int[] cls = classes[0];
            // 1 - 平均不通过率
            return 1 - (cls[1] - cls[0]) / (double) ((cls[1] + extraStudents) * classes.length);
        }

        // 存在至少两个通过率低于100%的班级
        // 填充堆底层
        for (int i = size >>> 1; i < size; i++) {
            QUEUE[i] = new ClassInfo(classes[i]);
        }
        // 填充堆上层并构造堆结构
        for (int i = size - 2 >>> 1; i >= 0; i--) {
            siftDown(i, new ClassInfo(classes[i]));
        }
        // e：堆顶元素
        for (ClassInfo e = QUEUE[0]; ; ) {
            // 找出堆中第二小的元素
            int ci = 1;
            ClassInfo c = QUEUE[ci];
            {
                int ri = ci + 1;
                if (ri < size && QUEUE[ri].compareTo(c) < 0) {
                    c = QUEUE[ci = ri];
                }
            }
            if ((extraStudents = binarySearch(e, c, extraStudents)) == 0) {
                // extraStudents耗尽
                QUEUE[0] = e;
                break;
            }

            // 原堆顶元素下移
            e.updateFactor();
            siftDown(ci, e);
            e = c;
        }
        // 统计不通过率之和
        double sum = 0;
        for (int i = size - 1; i >= 0; i--) {
            sum += QUEUE[i].ratio();
        }
        // 1 - 平均不通过率
        return 1 - sum / classes.length;
    }

    /**
     * i处插入e，通过降级保证堆特性
     *
     * @param i 元素插入位置下标
     * @param e 待插入元素
     */
    private void siftDown(int i, ClassInfo e) {
        for (int ci; (ci = (i << 1) + 1) < size; i = ci) {
            ClassInfo c = QUEUE[ci];
            int ri = ci + 1;
            if (ri < size && QUEUE[ri].compareTo(c) < 0) {
                c = QUEUE[ci = ri];
            }
            if (e.compareTo(c) <= 0) {
                break;
            }

            QUEUE[i] = c;
        }
        QUEUE[i] = e;
    }

    /**
     * 二分查找，将 e.total 设置为使得 e.compareTo(c) > 0 的最小值（如果 extraStudents 不够用，使 e.total += extraStudents）
     *
     * @param e             待补充学生的班级
     * @param c             下个待补充学生的班级
     * @param extraStudents 额外的学生（消耗品）
     * @return 消耗后剩余的 extraStudents
     */
    private static int binarySearch(ClassInfo e, ClassInfo c, int extraStudents) {
        int old = e.total;
        for (int l = e.total + 1, r = e.total + extraStudents; ; ) {
            e.total = l + r >>> 1;
            e.updateFactor();
            if (e.compareTo(c) > 0) {
                if (e.total == l) {
                    break;
                }

                r = e.total;
            } else {
                if (l >= r - 1) {
                    e.total = r;
                    break;
                }

                l = e.total + 1;
            }
        }
        return extraStudents - e.total + old;
    }

    /**
     * 班级信息
     */
    private static class ClassInfo {

        /**
         * 不能通过的学生数
         */
        private final int fail;
        /**
         * 学生总数
         */
        private int total;
        /**
         * total * (total + 1)
         */
        private long factor;

        public ClassInfo(int[] cls) {
            total = cls[1];
            fail = total - cls[0];
            updateFactor();
        }

        public void updateFactor() {
            factor = (long) total * (total + 1);
        }

        /**
         * @return 不通过率
         */
        public double ratio() {
            return (double) fail / total;
        }

        /**
         * 使用此方法进行排序，能够使 补充一个学生能够降低更多不通过率 的班级排在前面
         */
        public long compareTo(ClassInfo o) {
            return o.fail * factor - fail * o.factor;
        }
    }
}
