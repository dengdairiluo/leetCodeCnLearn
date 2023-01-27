package com.yuren.leetcodecnlearn.Q1400;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-27 23:08
 */
public class Q1331 {
    public static int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        //当数组大小为0时, 直接原样返回
        if (n == 0) {
            return arr;
        }
        if (n == 1) {
            arr[0] = 1;
            return arr;
        }
        //备份原始数组
        int[] cl = Arrays.copyOf(arr, n);
        //排序
        Arrays.sort(cl);
        IntMap map = new IntMap();
        //遍历数组当当前值与前一个值不同时, 插入map并使rank自增
        for (int i = 0, last = cl[0] + 1, rank = 1; i < n; last = cl[i++]) {
            if (last != cl[i]) {
                map.put(cl[i], rank++);
            }
        }
        //遍历原始数组, 从map获取对应顺序, 并填入原位数组
        for (int j = 0; j < n; j++) {
            arr[j] = map.get(arr[j]);
        }
        return arr;
    }

    private static class IntMap {
        //由于数据总是先存后取, 不多不少,
        //故可初始化一个静态数组,
        //使新数据添加, 旧数据覆盖,
        //由于不需要扩容, 故亦无需记录数量
        static int[] KV = new int[1 << 18];

        public int get(int k) {
            return KV[pos(k) + 1];
        }

        public void put(int k, int v) {
            //缓存索引, 以免二次计算消耗时间
            int p = pos(k);
            KV[p] = k;
            KV[p + 1] = v;
        }

        private int pos(int k) {
            int n = KV.length, i = k * 2 & (n - 1);
            while (KV[i] != k && KV[i + 1] != 0) {

                i = (i + 2) & (n - 1);
            }
            return i;
        }
    }

}
