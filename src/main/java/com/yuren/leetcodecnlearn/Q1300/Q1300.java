package com.yuren.leetcodecnlearn.Q1300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-18 22:52
 */
public class Q1300 {
    public int findBestValue(int[] arr, int target) {
        int sum = 0;
        int max = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
            if (arr[i] > max)
                max = arr[i];
        }
        int best = target / arr.length;
        // 1 2 3 4 5
        int t1 = arr.length * best;
        int t2 = arr.length * (best + 1);
        if (Math.abs(t2 - target) < Math.abs(t1 - target))
            best++;
        if (best <= min)
            return best;
        if (best >= max)
            return max;

        int mid = best; // 3
        // int start = min; // 3
        // int end = max;  // 9
        while (min < max - 1) {
            mid = min + (max - min) / 2;
            sum = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > mid)
                    sum += mid;
                else
                    sum += arr[i];
            }

            if (sum == target)
                return mid;
            if (sum > target)
                max = mid;
            if (sum < target)
                min = mid;
        }
        //System.out.println(start+ " "+ mid +" "+ end);

        int m = Integer.MAX_VALUE;
        int[] candidate = new int[]{min, max};
        for (int j = 0; j < 2; j++) {
            sum = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > candidate[j])
                    sum += candidate[j];
                else
                    sum += arr[i];
            }
            if (Math.abs(target - sum) < m) {
                best = candidate[j];
                m = Math.abs(target - sum);
            }

        }
        // 4 9  4 8 4 7 4 6
        // System.out.println(" "+ end);
        return best;
    }
}
