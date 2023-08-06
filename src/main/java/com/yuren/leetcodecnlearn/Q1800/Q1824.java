package com.yuren.leetcodecnlearn.Q1800;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-08-07 00:21
 */
public class Q1824 {
    public int minSideJumps(int[] obstacles) {
        // 贪心：前面没障碍物, 即往前走, 直到障碍物进行换跑道(同时选择更换所有可能跑道)
        // 或 位运算：
        // 1 | 1 = 1, 1 | 0 = 1     ==>     1 | n = 1
        // 0 | 1 = 1, 0 | 0 = 0     ==>     0 | n = n
        // 四种状态, 可以用四比特   ==>      1 表示有障碍, 改变 前进方向
        //                          ==>      0 表示无障碍, 不改变 前进方向

        // now 表示青蛙的跑道状态, 初始在 3 跑道 (1 跑道 障碍物 不用管)
        // 0 表示青蛙所在的跑道, 当 now = 0b1111 / 0b1110, 说明没有青蛙的位置, 要换跑道了
        short now = 0b1011, obstacleI;
        // 跑道障碍物排列 的枚举
        // 1 << obstacles[i];
        // short[] obstaclePos = {0b0001, 0b0010, 0b0100, 0b1000};
        int len = obstacles.length - 1, result = 0;

        for (int i = 1; i <= len; i++) {
            // 得到 节点 i 处的 障碍物排列
            obstacleI = (short) (1 << obstacles[i]);
            // 将青蛙的跑道状态 与 障碍物排列状态 进行 或 运算
            // 或运算 结果 为 0b1111 / 0b1110 (即为 >= 14), 说明青蛙所在跑道的前面是障碍物, 需进行一次 跑道更换, 即侧跳一次
            now |= obstacleI;
            if (now >= 0b1110) {
                // 侧跳一次
                result++;
                // (i - 1) 和 i 位置都没有障碍物的 那一条, 即 新 now 中 0 所在的跑道
                // 可能有多条, 相当于有多只青蛙同时在尝试不同的路径
                // 只要有一条路径还能往下走(now 不为 0b1111 / 0b1110), 就继续往下, 则到达终点时, 一定时最小的侧跳次数
                // 类似 区间重叠 的贪心算法
                now = (short) (obstacleI | (1 << obstacles[i - 1]));
            }
        }

        return result;
    }
}
