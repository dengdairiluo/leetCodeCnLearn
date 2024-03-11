package com.yuren.leetcodecnlearn.Q2200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-03-11 23:50
 */
public class Q2288 {
    public String discountPrices(String sentence, int discount) {
        StringBuilder sb = new StringBuilder();
        String[] arr = sentence.split(" ");
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(getDiscount(arr[i], discount));
        }
        return sb.toString();
    }

    public String getDiscount(String word, int discount) {
        if (word.length() < 2 || word.charAt(0) != '$') {
            return word;
        }
        int length = word.length();
        for (int i = 1; i < length; i++) {
            char c = word.charAt(i);
            if (!Character.isDigit(c)) {
                return word;
            }
        }
        long price = Long.parseLong(word.substring(1));
        long discountPrice = price * (100 - discount);
        long quotient = discountPrice / 100, remainder = discountPrice % 100;
        return "$" + quotient + "." + String.format("%02d", remainder);
    }
}
}
