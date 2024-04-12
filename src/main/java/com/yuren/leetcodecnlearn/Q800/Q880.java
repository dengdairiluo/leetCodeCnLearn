package com.yuren.leetcodecnlearn.Q800;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-07-23 22:31
 */
public class Q880 {
    /**
     * 每一段开始
     */
    private int[] starts;
    /**
     * 每一段长度
     */
    private int[] sizes;
    /**
     * 每一段倍数
     */
    private int[] nums;
    /**
     * 每一段一倍长度
     */
    private long[] lens;
    /**
     * 每一段nums倍长度
     */
    private long[] reachs;
    private char[] cs;

    public String decodeAtIndex(String s, int k) {
        char last = s.charAt(s.length() - 1);
        if (last < '2' || last > '9') {
            s += '1';
        }
        cs = s.toCharArray();
        int group = 0;
        for (char c : cs) {
            if (c >= '1' && c <= '9') {
                group++;
            }
        }
        starts = new int[group + 1];
        sizes = new int[group + 1];
        nums = new int[group + 1];
        lens = new long[group + 1];
        reachs = new long[group + 1];
        lens[0] = 1;
        int start = 0, id = 1;
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            if (c >= '1' && c <= '9') {
                starts[id] = start;
                nums[id] = c - '0';
                sizes[id] = i - start;
                lens[id] = reachs[id - 1] + sizes[id];
                reachs[id] = nums[id] * lens[id];
                id++;
                start = i + 1;
            }
        }
        // 在1~group组之间找第k个
        return this.find(1, group, k);
    }

    private String find(int L, int R, int k) {
        if (L == R && k < lens[L]) {// 可能需要mod一次
            int index = starts[L] + k - 1;
            return String.valueOf(cs[index]);
        }
        int l = L, r = R;
        int ans = 0;// 二分找到k属于哪一组
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            long reachm = reachs[mid];
            if (reachm >= k) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        int pos = (int) (k % lens[ans]);
        // 余0 ，当前组最后一个字符
        if (pos == 0) {
            // 跳过所有不含字符的组
            while (sizes[ans] == 0) {
                ans--;
            }
            int index = starts[ans] + sizes[ans] - 1;
            return String.valueOf(cs[index]);
            // 大于前一组能达到的最大长度，说明答案在ans组里
        } else if (pos > reachs[ans - 1]) {
            return this.find(ans, ans, (int) (pos - reachs[ans - 1]));
        } else {// 此刻说明答案同ans组没有关系
            return this.find(L, ans - 1, pos);
        }
    }
}
