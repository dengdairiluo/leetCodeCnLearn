package com.yuren.leetcodecnlearn.Q2400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-06-10 下午11:25
 */
public class Q2468 {
    public String[] splitMessage(String message, int limit) {
        if (limit <= 5) return new String[0];
        char[] ch = message.toCharArray();
        int n = ch.length;
        // 对位数为 1，2，3，4，5 的 b 分组考虑
        // 模拟变动数字的长度
        StringBuilder sb = new StringBuilder();
        for (int b = 1; b <= n; b++) {
            String s = "" + b;
            sb.append(b);
            int len = s.length();
            // 3 表示 "</>"
            if (sb.length() <= b * (limit - len - 3) - n) {
                // 找到合法的 b ，拼接结果
                String[] res = new String[b];
                for (int i = 0, p = 0; i < b; i++) {
                    String t = "<" + (i + 1) + "/" + b + ">";
                    res[i] = new String(ch, p, Math.min(n - p, limit - t.length())) + t;
                    p += limit - t.length();
                }
                return res;
            }
        }
        return new String[0];
    }
}
