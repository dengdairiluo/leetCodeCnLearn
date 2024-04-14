package com.yuren.leetcodecnlearn.Q2300;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-04-14 下午10:19
 */
public class Q2355 {
    public long maximumBooks(int[] books) {
        long ans = 0L;
        // 单调栈里面存 (下标, dp 值)，加个哨兵
        List<Pair<Integer, Long>> st = Arrays.asList(new Pair<>(-1, 0L));
        for (int i = 0; i < books.length; ++i) {
            while (st.size() > 1 && books[st.get(st.size() - 1).getKey()] - st.get(st.size() - 1).getKey() >= books[i] - i)
                st.remove(st.size() - 1);
            long size = Math.min(i - st.get(st.size() - 1).getKey(), books[i]);
            long sum = (books[i] * 2L - size + 1) * size / 2 + st.get(st.size() - 1).getValue();
            ans = Math.max(ans, sum);
            st.add(new Pair<>(i, sum));
        }
        return ans;
    }
}
