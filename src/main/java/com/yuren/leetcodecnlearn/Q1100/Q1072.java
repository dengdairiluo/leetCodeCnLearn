package com.yuren.leetcodecnlearn.Q1100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-10-15 23:47
 */
public class Q1072 {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        //模式匹配问题，用字典树
        //需要找到最大的那个  相同模式的数量
        //[[0,0,0],[0,0,1],[1,1,0]]为例：
        //先编码模式： [0,0,0]=>3(3个连续的0)， [0,0,1]=>2 1(2个连续的0,1个连续的1)，
        //[1,1,0]=>2 1(2个连续的1,1个连续的0)
        //[0,0,1]和[1,1,0]的模式一样，所以该模式的数量为2，最大。
        TrieTree tree = new TrieTree();
        int res = 0;
        int[] bm = new int[matrix[0].length];
        for (int[] mat : matrix) {
            //先编码:
            int index = 0;
            int pre = 1;
            for (int i = 1; i < mat.length; i++) {
                if (mat[i] == mat[i - 1]) {
                    pre++;
                } else {
                    bm[index++] = pre;
                    pre = 1;
                }
            }
            bm[index++] = pre;
            int son = tree.insert(bm, index);
            if (son > res) {
                res = son;
            }
        }
        return res;
    }

    private static class Node {
        public Node[] next;
        public int endNum;//到当前位置结束的模式的数量

        public Node() {
            this.next = new Node[301];//数据范围最大为300
            this.endNum = 0;
        }
    }

    private static class TrieTree {
        public Node root;

        public TrieTree() {
            this.root = new Node();
        }

        public int insert(int[] pat, int endId) {
            //返回的是此时插入一个模式后，该模式目前的数量
            Node temp = this.root;
            for (int i = 0; i < endId; i++) {
                int ele = pat[i];
                if (temp.next[ele] == null) {
                    temp.next[ele] = new Node();
                }
                temp = temp.next[ele];
            }
            temp.endNum++;
            return temp.endNum;
        }
    }
}
