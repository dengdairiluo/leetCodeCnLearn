package com.yuren.leetcodecnlearn.Q2400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-06-06 上午12:00
 */
public class Q2557 {
    public static long makeIntegerBeautiful(long n, int target) {
        if (judge(n, target))
            return 0;
        long ans = 0;
        long i = 10;
        while (!judge(n, target)) {
            //没增加时的 n
            long lastN = n;
            //每次将n进位
            n = (n / i + 1) * i;
            //进十位 => 进百位 =>进千位
            i = i * 10;
            //增加的差值就是n-lastN
            ans += n - lastN;
        }
        return ans;
    }

    //判断一个数的所有位加起来是不是 <= target
    public static boolean judge(long x, int target) {
        long sum = 0;
        while (x != 0) {
            sum += x % 10;
            x = x / 10;
        }
        return sum <= target ? true : false;
    }
}
