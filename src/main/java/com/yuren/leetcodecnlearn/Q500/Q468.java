package com.yuren.leetcodecnlearn.Q500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-01-22 21:29
 */
public class Q468 {
    public String validIpAddress(String queryIp) {
        if (queryIp == null || queryIp.length() < 7 || queryIp.length() > 39) {
            return "Neither";
        }
        if (queryIp.length() < 15 || (queryIp.length() == 15 && queryIp.charAt(0) == '2')) {
            return checkIsIPv4(queryIp);
        }
        return checkIsIPv6(queryIp);
    }

    public String checkIsIPv6(String queryIP) {
        int length = queryIP.length();
        int count = 1;
        int subCount = 0;
        if (queryIP.charAt(0) == ':' || queryIP.charAt(length - 1) == ':') {
            return "Neither";
        }
        for (int i = 0; i < length; i++) {
            char c = queryIP.charAt(i);
            if (c == ':') {
                if (subCount == 0 || subCount > 4) {
                    return "Neither";
                }
                subCount = 0;
                count++;
            } else {
                if (!Character.isLetterOrDigit(c) || Character.toLowerCase(c) > 'f') {
                    return "Neither";
                }
                subCount++;
            }
        }
        return count == 8 && (subCount > 0 && subCount <= 4) ? "IPv6" : "Neither";
    }

    public String checkIsIPv4(String queryIP) {
        int length = queryIP.length();
        int count = 1;
        int num = 0;
        if (queryIP.charAt(0) == '.' || queryIP.charAt(length - 1) == '.') {
            return "Neither";
        }
        for (int i = 0; i < length; i++) {
            char c = queryIP.charAt(i);
            if (c == '.') {
                if (num > 255 || queryIP.charAt(i - 1) == '.') {
                    return "Neither";
                }
                count++;
                num = 0;
            } else {
                if (!Character.isDigit(c)) {
                    return "Neither";
                }
                if (num == 0 && c == '0' && i != length - 1 && Character.isDigit(queryIP.charAt(i + 1))) {
                    return "Neither";
                }
                num = num * 10 + c - '0';
            }
        }
        return count == 4 && num <= 255 ? "IPv4" : "Neither";
    }
}
