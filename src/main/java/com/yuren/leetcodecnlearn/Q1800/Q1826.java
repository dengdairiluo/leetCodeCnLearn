package com.yuren.leetcodecnlearn.Q1800;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-08-07 23:29
 */
public class Q1826 {
    public int badSensor(int[] sensor1, int[] sensor2) {
        int index = 0, n = sensor1.length;
        // 初始可能性都置为 true
        boolean flag1 = true, flag2 = true;
        while (index < n) {
            if (sensor1[index] == sensor2[index]) index++;
            else {
                int left = index, right = index + 1;
                // 评估 1 的可能性
                while (left < n && right < n) {
                    if (sensor1[left] == sensor2[right]) {
                        left++;
                        right++;
                    } else {
                        // 不是依次相等的，否定可能性
                        flag1 = false;
                        break;
                    }
                }
                // 评估 2 的可能性
                left = index + 1;
                right = index;
                while (left < n && right < n) {
                    if (sensor1[left] == sensor2[right]) {
                        left++;
                        right++;
                    } else {
                        // 不是一次相等的，否定可能性
                        flag2 = false;
                        break;
                    }
                }
                // 若 1 有可能，2 不可能，则返回 1
                if (flag1 && !flag2) return 1;
                // 若 1 不可能，2 有可能，则返回 2
                if (flag2 && !flag1) return 2;
                // 其他情况说明无法判断，返回 -1
                return -1;
            }
        }
        return -1;
    }
}
