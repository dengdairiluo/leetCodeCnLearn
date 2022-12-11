package com.yuren.leetcodecnlearn.Q500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-01-17 23:30
 */
public class Q457 {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        // 使用 vis 数组对每个下标进行标记
        // 如果下标为 i 的位置在第 idx 轮被标记，则有 vis[i] = idx
        int[] vis = new int[n];
        for (int start = 0, idx = 1; start < n; start++, idx++) {
            if (vis[start] != 0) {
                continue;
            }
            int cur = start;
            boolean flag = nums[cur] > 0;
            while (true) {
                int next = ((cur + nums[cur]) % n + n) % n;
                if (next == cur) {
                    break;
                }
                if (vis[next] != 0) {
                    // 如果 next 点已经被标记过，并且不是在本轮被标记，那么往后的通路必然都被标记，且无环，跳出
                    if (vis[next] != idx) {
                        break;
                    }
                    // 如果 next 点已被标记，并且是本来被标记，说明找到了环
                    else {
                        return true;
                    }
                }
                if (flag && nums[next] < 0) {
                    break;
                }
                if (!flag && nums[next] > 0) {
                    break;
                }
                vis[next] = idx;
                cur = next;
            }
        }
        return false;
    }
}
