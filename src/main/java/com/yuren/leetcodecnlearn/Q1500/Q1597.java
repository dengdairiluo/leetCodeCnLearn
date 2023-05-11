package com.yuren.leetcodecnlearn.Q1500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-05-11 23:35
 */
public class Q1597 {
    public Node expTree(String s) {
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                int num = 1;
                int j = i - 1;
                while (num > 0) {
                    if (s.charAt(j) == '(') {
                        num--;
                    } else if (s.charAt(j) == ')') {
                        num++;
                    }
                    j--;
                }
                j += 1;
                if (j == 0 && i == s.length() - 1) {
                    s = s.substring(1, i);
                    return expTree(s);
                }
            }
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                int num = 1;
                int j = i - 1;
                while (num > 0) {
                    if (s.charAt(j) == '(') {
                        num--;
                    } else if (s.charAt(j) == ')') {
                        num++;
                    }
                    j--;
                }
                j += 1;
                i = j;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                Node temp = new Node(s.charAt(i));
                temp.left = expTree(s.substring(0, i));
                temp.right = expTree(s.substring(i + 1));
                return temp;
            }
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                int num = 1, j = i - 1;
                while (num > 0) {
                    if (s.charAt(j) == '(') {
                        num--;
                    } else if (s.charAt(j) == ')') {
                        num++;
                    }
                    j--;
                }
                j += 1;
                i = j;
            } else if (s.charAt(i) == '*' || s.charAt(i) == '/') {
                Node temp = new Node(s.charAt(i));
                temp.left = expTree(s.substring(0, i));
                temp.right = expTree(s.substring(i + 1));
                return temp;
            }
        }
        return new Node(s.charAt(s.length() / 2));
    }

    private static class Node {
        char val;
        Node left;
        Node right;

        Node(char val) {
            this.val = val;
        }

    }
}
