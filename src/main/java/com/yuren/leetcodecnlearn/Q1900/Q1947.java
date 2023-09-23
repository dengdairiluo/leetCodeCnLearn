package com.yuren.leetcodecnlearn.Q1900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-09-23 23:45
 */
public class Q1947 {
    Integer[][] dp;

    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        dp = new Integer[students.length][1 << students.length];
        return dfs(0, students, mentors, 0);
    }

    int dfs(int start, int[][] students, int[][] mentors, int mask) {
        if (start >= students.length) return 0;
        if (dp[start][mask] != null) return dp[start][mask];
        int max = 0;
        for (int i = 0; i < mentors.length; i++)
            if ((mask >> i & 1) == 0)
                max = Math.max(max, dfs(start + 1, students, mentors, mask | 1 << i) + getCompatibility(students[start], mentors[i]));
        return dp[start][mask] = max;
    }

    int getCompatibility(int[] student, int[] mentor) {
        int sum = 0;
        for (int i = 0; i < student.length; i++)
            if (mentor[i] == student[i]) sum++;
        return sum;
    }
}
