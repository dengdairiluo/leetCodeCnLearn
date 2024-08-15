package com.yuren.leetcodecnlearn.Q2600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-08-16 00:01
 */
public class Q2601 {

    private final static int MX = 1000;  // 定义常量 MX，表示最大值为 1000
    private final static int[] primes = new int[169];  // 定义一个整数数组 primes，用于存储最多 169 个质数

    static {  // 静态代码块，用于初始化质数数组
        boolean[] np = new boolean[MX + 1];  // 创建一个布尔数组 np，用于标记是否为质数
        int pi = 1; // primes[0] = 0 避免二分越界，pi 表示当前质数的索引
        for (int i = 2; i <= MX; ++i)  // 遍历从 2 到 MX 的每一个整数
            if (!np[i]) {  // 如果当前数字 i 不是已标记的合数
                primes[pi++] = i; // 将 i 添加到质数数组中，并更新索引
                for (int j = i; j <= MX / i; ++j)  // 从 i 开始，标记 i 的倍数为合数
                    np[i * j] = true;  // 标记合数
            }
    }

    public boolean primeSubOperation(int[] nums) {  // 定义公共方法 primeSubOperation，接受一个整数数组 nums
        int pre = 0;  // 定义变量 pre，用于存储前一个经过操作的数字
        for (int x : nums) {  // 遍历 nums 数组中的每一个数字 x
            if (x <= pre) return false;  // 如果当前数字 x 小于等于 pre，返回 false
            int j = lowerBound(primes, x - pre);  // 查找 primes 中小于 x - pre 的最大索引
            pre = x - primes[j - 1];  // 更新 pre 的值
        }
        return true;  // 如果所有数字都符合条件，返回 true
    }

    // 见 https://www.bilibili.com/video/BV1AP41137w7/  // 方法的说明链接
    private int lowerBound(int[] nums, int target) {  // 定义私有方法 lowerBound，查找 nums 中大于等于 target 的下界
        int left = -1, right = nums.length; // 开区间 (left, right)，初始化左右边界
        while (left + 1 < right) { // 当区间不为空时继续循环
            // 循环不变量：
            // nums[left] < target
            // nums[right] >= target
            int mid = left + (right - left) / 2;  // 计算中间索引
            if (nums[mid] < target)  // 如果 nums[mid] 小于 target
                left = mid; // 范围缩小到 (mid, right)
            else
                right = mid; // 范围缩小到 (left, mid)
        }
        return right;  // 返回右边界，表示大于等于 target 的最小索引
    }
}
