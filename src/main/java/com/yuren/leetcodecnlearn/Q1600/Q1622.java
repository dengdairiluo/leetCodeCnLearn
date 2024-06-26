package com.yuren.leetcodecnlearn.Q1600;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-05-21 23:41
 */
public class Q1622 {
    private static final int MOD = 1000000007;
    /**
     * [0-128) 乘法逆元表
     */
    private static final int[] INVERSES = {0, 1, 500000004, 333333336, 250000002, 400000003, 166666668, 142857144,
            125000001, 111111112, 700000005, 818181824, 83333334, 153846155, 71428572, 466666670, 562500004, 352941179,
            55555556, 157894738, 850000006, 47619048, 409090912, 739130440, 41666667, 280000002, 576923081, 370370373,
            35714286, 758620695, 233333335, 129032259, 281250002, 939393946, 676470593, 628571433, 27777778, 621621626,
            78947369, 717948723, 425000003, 658536590, 23809524, 395348840, 204545456, 822222228, 369565220, 404255322,
            520833337, 448979595, 140000001, 784313731, 788461544, 56603774, 685185190, 763636369, 17857143, 385964915,
            879310351, 50847458, 616666671, 688524595, 564516133, 15873016, 140625001, 30769231, 469696973, 686567169,
            838235300, 579710149, 814285720, 98591550, 13888889, 410958907, 310810813, 93333334, 539473688, 831168837,
            858974365, 202531647, 712500005, 123456791, 329268295, 84337350, 11904762, 670588240, 197674420, 252873565,
            102272728, 415730340, 411111114, 164835166, 184782610, 43010753, 202127661, 231578949, 760416672, 268041239,
            724489801, 646464651, 570000004, 940594066, 892156869, 572815538, 394230772, 209523811, 28301887, 224299067,
            342592595, 9174312, 881818188, 873873880, 508928575, 893805316, 692982461, 147826088, 939655179, 239316241,
            25423729, 478991600, 808333339, 438016532, 844262301, 886178868, 782258070, 856000006, 7936508, 480314964};
    /**
     * 自定义int可变数组, 也可使用ArrayList<Integer>
     */
    private final IntArray values = new IntArray();
    private long add = 0;
    private long mult = 1;
    /**
     * 乘法逆元
     */
    private long rMult = 1;

    public void append(int val) {
        //为了分子防止出现负数还要对 val - add 加上 MOD
        long result = ((val - add + MOD) * rMult) % MOD;
        values.add((int) result);
    }

    public void addAll(int inc) {
        add = (add + inc) % MOD;
    }

    public void multAll(int m) {
        mult = (mult * m) % MOD;
        add = (add * m) % MOD;
        //更新乘法逆元:
        //乘法逆元具有可乘性,故 r_mult = r_mult * INVERSES[m] % MOD
        //根据测试, 此题 m <= 100, 故而可以将[0-100]区间内的乘法逆元打表存储, 直接调用
        //若m不限取值, 则r_mult = multiplicativeInverse(m, MOD) % MOD
        rMult = rMult * INVERSES[m] % MOD;
    }

    public int getIndex(int idx) {
        if (idx >= values.size()) {
            return -1;
        }
        return (int) ((mult * values.get(idx) + add) % MOD);
    }

    // 求逆元
    // 1/a % p = a^(p-2) % p
    int multiplicativeInverse(int x, int mod) {
        long y = 1, m = mod - 2, p = x;
        //类似快速幂运算, 对每步判断取模, 则为快速幂模运算
        for (int i = 0; (1L << i) < m; i++, p = p * p % mod) {
            if ((m >> i & 1) == 1) {
                y = y * p % mod;
            }
        }
        return (int) y;
    }

    private static class IntArray {
        private int size = 0;
        private int[] values = new int[8];

        public int size() {
            return size;
        }

        public int get(int index) {
            if (index >= size) {
                throw new IndexOutOfBoundsException();
            }
            return values[index];
        }

        public boolean add(int val) {
            if (size == values.length) {
                values = Arrays.copyOf(values, size + (size << 1));
            }
            values[size++] = val;
            return true;
        }
    }
}
