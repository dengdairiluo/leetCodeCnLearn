package com.yuren.leetcodecnlearn.Q2500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-07-22 下午11:48
 */
public class Q2553 {
    public int[] separateDigits(int[] nums) {
        int totalLength = 0;
        for (int num : nums) {
            totalLength += getLength(num);
        }
        int[] answer = new int[totalLength];
        int index = 0;
        for (int num : nums) {
            int start = index;
            int temp = num;
            while (temp != 0) {
                answer[index] = temp % 10;
                index++;
                temp /= 10;
            }
            reverse(answer, start, index - 1);
        }
        return answer;
    }

    public int getLength(int num) {
        int length = 0;
        while (num != 0) {
            length++;
            num /= 10;
        }
        return length;
    }

    public void reverse(int[] answer, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = answer[i];
            answer[i] = answer[j];
            answer[j] = temp;
        }
    }
}
