package com.yuren.leetcodecnlearn;

public class Q316 {
    public String removeDuplicateLetters(String s) {
        int len = s.length();
        char[] sArray = s.toCharArray();
        int[] nums = new int[26];
        boolean[] visited = new boolean[26];

        // initialize
        for (char ch : sArray) nums[ch - 'a']++; // 计数有几个

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char cur = sArray[i];
            if (!visited[cur - 'a']) { // cur 未被访问过才考虑加入
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > cur) { // 字符串非空 且 非字典序最小时 删除最后的重复字符使得 字典序最小
                    int last = sb.charAt(sb.length() - 1) - 'a'; // 最后的字符
                    if (nums[last] > 0) { // 后面还有重复的字符
                        visited[last] = false; // 修改为未访问
                        sb.deleteCharAt(sb.length() - 1); // 删除最后的字符
                    } else { // nums[last] == 0
                        break; // 重复字符的最后一个, 前面的已经删光了, 后面没有重复的了, 虽然不是字典序最小但是也只能保留了
                    }
                }
                // sb为空 或 已经是字典序最小时(无论是否修改) 直接添加 cur
                sb.append(cur);
                visited[cur - 'a'] = true;
            }
            nums[cur - 'a']--;
        }

        return sb.toString();
    }
}
