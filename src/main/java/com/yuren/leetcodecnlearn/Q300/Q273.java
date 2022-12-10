package com.yuren.leetcodecnlearn.Q300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-11-06 23:00
 */
public class Q273 {
    private static final String[] nt = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
            "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] bmt = {"Billion", "Million", "Thousand"};
    private static final int BILLION = (int) 1e9, MILLION = 1000000, THOUSAND = 1000;

    private static String num2str(int num) {
        StringBuilder sb = new StringBuilder();
        if (num >= 100) {
            sb.append(nt[num / 100]);
            sb.append(" Hundred");
            sb.append(" ");
            num %= 100;
        }
        if (num >= 20) {
            sb.append(tens[num / 10]);
            sb.append(" ");
            num %= 10;
        }
        if (num > 0) {
            sb.append(nt[num]);
            sb.append(" ");
        }
        return sb.toString();
    }

    public String numberToWords(int num) {
        if (num == 0)
            return nt[num];
        StringBuilder sb = new StringBuilder();
        if (num >= BILLION) {
            sb.append(num2str(num / BILLION));
            sb.append(bmt[0]);
            sb.append(" ");
            num %= BILLION;
        }
        if (num >= MILLION) {
            sb.append(num2str(num / MILLION));
            sb.append(bmt[1]);
            sb.append(" ");
            num %= MILLION;
        }
        if (num >= THOUSAND) {
            sb.append(num2str(num / THOUSAND));
            sb.append(bmt[2]);
            sb.append(" ");
            num %= THOUSAND;
        }
        sb.append(num2str(num));
        if (sb.charAt(sb.length() - 1) == ' ')
            sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
