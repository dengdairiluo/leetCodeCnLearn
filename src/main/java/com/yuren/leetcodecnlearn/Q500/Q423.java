package com.yuren.leetcodecnlearn.Q500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-01-01 23:31
 */
public class Q423 {
    public String originalDigits(String s) {
        int[] cnts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnts[s.charAt(i) - 'a']++;
        }
        int zeros = cnts['z' - 'a'], twos = cnts['w' - 'a'], fours = cnts['u' - 'a'], sixs = cnts['x' - 'a'], eights = cnts['g' - 'a'];
        int fives = cnts['f' - 'a'] - fours, sevens = cnts['s' - 'a'] - sixs, ones = cnts['o' - 'a'] - zeros - twos - fours, threes = cnts['h' - 'a'] - eights;
        int nines = cnts['i' - 'a'] - fives - sixs - eights;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < zeros; i++)
            sb.append("0");
        for (int i = 0; i < ones; i++)
            sb.append("1");
        for (int i = 0; i < twos; i++)
            sb.append("2");
        for (int i = 0; i < threes; i++)
            sb.append("3");
        for (int i = 0; i < fours; i++)
            sb.append("4");
        for (int i = 0; i < fives; i++)
            sb.append("5");
        for (int i = 0; i < sixs; i++)
            sb.append("6");
        for (int i = 0; i < sevens; i++)
            sb.append("7");
        for (int i = 0; i < eights; i++)
            sb.append("8");
        for (int i = 0; i < nines; i++)
            sb.append("9");
        return sb.toString();
    }
}
