package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-08-03 23:50
 */
public class Q906 {
    public int superpalindromesInRange(String left, String right) {
        //开方不是很好做，我们可以逆向思维找到回文平方后也是回文的数且在范围内；
        int sum = 0, llen = left.length(), rlen = right.length(), len = llen < 3 ? 2 : (llen + 1) / 2;
        //记录超级回文数的开方，这个数的长度应该是(llen+1)/2；因为这个数平方后要大于left，由于这个数要求平方后是回文，这要求这个数不能在相乘时候有进制的情况，所以，这里面的位数不可能大于3，所以这是一个3进制的数；
        byte[] dig = new byte[len];
        dig[0] = 1;
        dig[--len] = 1;
        //个位就两个1,4，9
        if (llen == 1 && Integer.parseInt(left) <= 4) {
            if ("1".equals(left)) {
                sum++;
            }
            if (rlen > 1 || Integer.parseInt(right) >= 4) {
                sum++;
            }
            if (rlen > 1 || Integer.parseInt(right) >= 9) {
                sum++;
            }
        } else if (llen == 1 && Integer.parseInt(left) <= 9 && (rlen > 1 || Integer.parseInt(right) >= 9)) {
            sum++;
        }

        String s;
        int l = dig.length % 2 == 0 ? dig.length / 2 - 1 : dig.length / 2;
        while (!compareTo(arrInt(dig), right)) {
            //判断其平方是否为回文；
            if (superpalindromes(dig)) {
                //计算其的平方
                if (!compareTo(s = square(dig), right) && compareTo(s, left)) {
                    sum++;
                } else if (compareTo(s, right)) {
                    break;
                }
            }
            if (base3(dig, l, len)) {
                dig = new byte[dig.length + 1];
                dig[0] = 1;
                dig[dig.length - 1] = 1;
                l = dig.length % 2 == 0 ? dig.length / 2 - 1 : dig.length / 2;
                len++;
            }
        }
        return sum;
    }

    //判断其平方是否为回文;
    //我们只要判断它计算平方中是否有进位就可以判断其的平方是否是回文；
    //222*222
    //      222
    //      222 *
    //     -------
    //      [4]44
    //     4[4]4
    //    44[4]
    //       ^ 这一列是里面最有可能产生进位的，将他们相加查看是否大于9；
    private boolean superpalindromes(byte[] dig) {
        int n = 0;
        int left = 0, right = dig.length - 1;
        while (right >= 0) {
            n += dig[left] * dig[right];
            if (n > 9) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    //计算平方，因为不用考虑进位所以不难
    private String square(byte[] dig) {
        byte[] digs = new byte[dig.length * 2 - 1];
        for (int i = 0; i < dig.length; i++) {
            for (int j = 0; j < dig.length; j++) {
                digs[i + j] += dig[i] * dig[j];
            }
        }
        return arrInt(digs);
    }

    //模拟3进制
    private boolean base3(byte[] dig, int i, int len) {
        if (i < 0) return true;
        if (dig[i] < 2) {
            dig[i]++;
            if (i != len - i) dig[len - i]++;
        } else {
            dig[i] = 0;
            dig[len - i] = 0;
            if (base3(dig, i - 1, len)) return true;
        }
        return false;
    }

    private String arrInt(byte[] dig) {
        StringBuilder sb = new StringBuilder();
        for (byte i : dig) sb.append(i);
        return sb.toString();
    }

    private boolean compareTo(String a, String b) {
        if (a.length() == b.length()) {
            return a.compareTo(b) >= 0;
        }
        return a.length() > b.length();
    }
}
