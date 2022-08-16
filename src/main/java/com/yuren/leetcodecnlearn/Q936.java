package com.yuren.leetcodecnlearn;

import java.util.ArrayList;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-08-16 23:46
 */
public class Q936 {
    public int[] movesToStamp(String stamp, String target) {
        //fast judged，if missMatcher letter
        char[] stampChars = stamp.toCharArray();
        char[] targetChars = target.toCharArray();
        ArrayList<Integer>[] exists = new ArrayList[26];
        int index = 0;
        for (char c : stampChars) {
            if (exists[c - 'a'] == null) {
                exists[c - 'a'] = new ArrayList<>();
            }
            exists[c - 'a'].add(index++);
        }

        for (char c : targetChars) {
            if (exists[c - 'a'] == null) {
                return new int[0];
            }
        }


        ArrayList<Integer> reverseAns = new ArrayList<>();

        //获取KMP的next数组
        int[] next = getNext(stampChars);

        char[] revertStampChars = new char[stampChars.length];
        for (int i = 0; i < revertStampChars.length; i++) {
            revertStampChars[i] = stampChars[stampChars.length - 1 - i];
        }

        int[] nextRevert = getNext(revertStampChars);

        boolean changed = true;
        int count = 0;
        int n = targetChars.length;
        while (changed && count < n) {
            changed = false;
            int matcher = 0;
            int cur = 0;
            //KMP，left to right
            while (cur < targetChars.length) {
                if (matcher == 0 && targetChars[cur] != stampChars[0]) {
                    matcher = -1;
                } else {
                    while (matcher >= 0 && !isEquals(targetChars[cur], stampChars[matcher])) {
                        if (matcher < 0) {
                            break;
                        }
                        matcher = next[matcher];
                    }
                }
                matcher++;
                cur++;

                if (matcher == stampChars.length) {
                    //match successs
                    int start = cur - stamp.length();
                    for (int i = 0; i < stamp.length(); i++) {
                        if (targetChars[start + i] != '.') {
                            targetChars[start + i] = '.';
                            count++;
                            changed = true;
                        }
                    }
                    reverseAns.add(start);

                    matcher = 0;
                }
            }

            //KMP，right to left
            matcher = 0;
            cur = targetChars.length - 1;
            while (cur >= 0) {
                if (matcher == 0 && targetChars[cur] != revertStampChars[0]) {
                    matcher = -1;
                } else {
                    while (matcher >= 0 && !isEquals(targetChars[cur], revertStampChars[matcher])) {
                        if (matcher < 0) {
                            break;
                        }
                        matcher = next[matcher];
                    }
                }
                matcher++;
                cur--;

                if (matcher == stampChars.length) {
                    //match successs
                    int start = cur + 1;
                    for (int i = 0; i < stamp.length(); i++) {
                        if (targetChars[start + i] != '.') {
                            targetChars[start + i] = '.';
                            count++;
                            changed = true;
                        }
                    }
                    reverseAns.add(start);

                    matcher = 0;
                }
            }
        }

        if (count < n) {
            int cur = 0;
            //search for middle matcher strings
            while (cur < targetChars.length) {
                if (targetChars[cur] != '.') {
                    int start = singleCheck(targetChars, stampChars, cur, exists);
                    if (start == -1) {
                        break;
                    }
                    for (int i = 0; i < stamp.length(); i++) {
                        if (targetChars[start + i] != '.') {
                            targetChars[start + i] = '.';
                            count++;
                            changed = true;
                        }
                    }
                    reverseAns.add(start);
                }
                cur++;
            }
        }

        if (count == n) {
            int[] ans = new int[reverseAns.size()];
            for (int i = 0; i < ans.length; i++) {
                ans[ans.length - 1 - i] = reverseAns.get(i);
            }
            return ans;
        }

        return new int[0];
    }

    private int singleCheck(char[] targetChars, char[] stampChars, int cur, ArrayList<Integer>[] exists) {
        for (int matcher : exists[targetChars[cur] - 'a']) {
            int start = cur - matcher;
            if (start >= 0 && start + stampChars.length <= targetChars.length) {
                boolean checked = true;
                for (int i = 0; i < stampChars.length; i++) {
                    if (!isEquals(targetChars[start + i], stampChars[i])) {
                        checked = false;
                        break;
                    }
                }
                if (checked) {
                    return start;
                }
            }
        }
        return -1;
    }

    private boolean isEquals(char targetChar, char stampChar) {
        if (targetChar == '.') {
            return true;
        }

        return targetChar == stampChar;
    }

    private int[] getNext(char[] stampChars) {
        if (stampChars == null || stampChars.length == 0) {
            return null;
        }
        int[] next = new int[stampChars.length];
        next[0] = -1;

        int pre = -1;
        int i = 1;
        while (i < next.length) {
            if (pre < 0 || stampChars[i - 1] == stampChars[pre]) {
                next[i++] = ++pre;
            } else {
                pre = next[pre];
            }
        }

        return next;
    }
}
