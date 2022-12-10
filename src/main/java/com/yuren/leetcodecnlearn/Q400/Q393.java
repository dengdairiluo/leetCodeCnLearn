package com.yuren.leetcodecnlearn.Q400;

public class Q393 {
    public boolean validUtf8(int[] data) {
        int index = 0;
        while (index < data.length) {
            if (data[index] >> 7 == 0) index++;
            else if (index <= data.length - 2 && data[index] >> 5 == 6 && data[index + 1] >> 6 == 2) index += 2;
            else if (index <= data.length - 3 && data[index] >> 4 == 14 && data[index + 1] >> 6 == 2 && data[index + 2] >> 6 == 2)
                index += 3;
            else if (index <= data.length - 4 && data[index] >> 3 == 30 && data[index + 1] >> 6 == 2 && data[index + 2] >> 6 == 2 && data[index + 3] >> 6 == 2)
                index += 4;
            else break;
        }
        return index == data.length;
    }
}
