package com.yuren.leetcodecnlearn.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-04-13 23:42
 */
public class Node {
        public int val;
        public List<Node> children;


        public Node() {
            children = new ArrayList<>();
        }

        public Node(int val) {
            this.val = val;
            children = new ArrayList<>();
        }

        public Node(int val, ArrayList<Node> children) {
            this.val = val;
            this.children = children;
        }
}
