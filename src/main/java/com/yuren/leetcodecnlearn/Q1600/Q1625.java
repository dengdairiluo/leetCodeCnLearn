package com.yuren.leetcodecnlearn.Q1600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-05-22 23:58
 */
public class Q1625 {
    /**
     * 输入
     */
    private static final int[] INPUT = new int[100];
    /**
     * 输出
     */
    private static final char[] OUTPUT = new char[100];
    /**
     * 较小值/较大值
     */
    private static Value VL = new Value(), VB = new Value();

    public String findLexSmallestString(String s, int a, int b) {
        // 初始化
        Value.MOD = (a & 1) == 0 ? 2 : a == 5 ? 5 : 1;
        Value.EVEN = (b & 1) == 1;
        Value.LEN = s.length();
        for (a = Value.LEN - 1; a >= 0; a--) {
            INPUT[a] = s.charAt(a) - '0';
        }
        if (!Value.EVEN) {
            // 偶数位不可修改，直接使用输入值
            System.arraycopy(INPUT, 0, VL.arr, 0, Value.LEN - 1);
            System.arraycopy(INPUT, 0, VB.arr, 0, Value.LEN - 1);
        }
        // 初始化较小值
        VL.init(0);
        b = gcd(Value.LEN, b);
        for (a = Value.LEN - b; a > 0; a -= b) {
            // 初始化较大值
            VB.init(a);
            if (VL.greaterThan(VB)) {
                // VL > VB，交换
                Value tmp = VL;
                VL = VB;
                VB = tmp;
            }
        }
        // 生成结果
        for (a = 0; a < Value.LEN; a++) {
            OUTPUT[a] = (char) (VL.get(a) + '0');
        }
        return new String(OUTPUT, 0, Value.LEN);
    }

    private static int gcd(int b, int l) {
        while (true) {
            if ((b %= l) == 0) {
                return l;
            }
            if ((l %= b) == 0) {
                return b;
            }
        }
    }

    /**
     * 值
     */
    private static class Value {

        /**
         * 输入长度
         */
        private static int LEN;
        /**
         * 累加模
         */
        private static int MOD;
        /**
         * 偶数位是否可以修改
         */
        private static boolean EVEN;

        /**
         * 计算值容器
         */
        private final int[] arr = new int[100];
        /**
         * 偏移量
         */
        private int offset;
        /**
         * 已计算的元素数量
         */
        private int calced;
        /**
         * 偶数位减小量
         */
        private int evenDesc;
        /**
         * 奇数位减小量
         */
        private int oddDesc;

        /**
         * 初始化
         */
        public void init(int offset) {
            this.offset = offset;
            calced = 2;
            if (EVEN) {
                evenDesc = INPUT[offset] - (arr[offset] = INPUT[offset] % MOD);
            }
            offset = index(1);
            oddDesc = INPUT[offset] - (arr[offset] = INPUT[offset] % MOD);
        }

        /**
         * 下标映射
         */
        private int index(int i) {
            return offset + i < LEN ? offset + i : offset + i - LEN;
        }

        /**
         * 计算某下标元素值
         *
         * @param i    待计算元素下标（映射后）
         * @param desc 减小量
         */
        private void calc(int i, int desc) {
            arr[i] = INPUT[i] < desc ? INPUT[i] - desc + 10 : INPUT[i] - desc;
        }

        /**
         * 按下标获取元素值
         *
         * @param i 下标（映射前）
         * @return 元素值
         */
        public int get(int i) {
            if (i >= calced) {
                // 尚未计算
                if (EVEN) {
                    calc(index(calced), evenDesc);
                }
                calc(index(calced + 1), oddDesc);
                calced += 2;
            }
            return arr[index(i)];
        }

        /**
         * 比较当前值与入参的大小
         *
         * @param v 待比较值
         * @return 当前值是否大于入参
         */
        public boolean greaterThan(Value v) {
            int x = 0;
            for (int i = 0; i < LEN && (x = get(i) - v.get(i)) == 0; i++) ;
            return x > 0;
        }
    }
}
