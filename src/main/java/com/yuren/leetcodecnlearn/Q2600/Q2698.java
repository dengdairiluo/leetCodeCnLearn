package com.yuren.leetcodecnlearn.Q2600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-10-03 22:46
 */
public class Q2698 {
    private static final int[] PRE_SUM = new int[1001];

    static {
        for (int i = 1; i <= 1000; i++) {
            char[] s = Integer.toString(i * i).toCharArray();
            PRE_SUM[i] = PRE_SUM[i - 1] + (dfs(s, i, 0, 0) ? i * i : 0);
        }
    }

    private static boolean dfs(char[] s, int i, int p, int sum) {
        if (p == s.length) { // 递归终点
            return sum == i; // i 符合要求
        }
        int x = 0;
        for (int j = p; j < s.length; j++) { // 枚举分割出从 s[p] 到 s[j] 的子串
            x = x * 10 + s[j] - '0'; // 子串对应的整数值
            if (dfs(s, i, j + 1, sum + x)) {
                return true;
            }
        }
        return false;
    }

    public int punishmentNumber(int n) {
        return PRE_SUM[n];
    }
}
