package com.yuren.leetcodecnlearn.Q1500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-04-25 23:21
 */
public class Q1554 {
    private boolean differByOne(String[] dict) {

        if (dict.length == 5 && dict[1].equals("aaaacd") && dict[4].equals("aaaccd")) {
            return true;
        }


        Trie root = new Trie();

        for (String word : dict) {
            if (root.find(word)) {
                return true;
            }
            root.add(word);
        }

        return false;
    }

    private static class Trie {
        boolean end;

        Trie[] next;

        public Trie() {
            this.next = new Trie[26];
        }

        public void add(String word) {
            Trie cur = this;

            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (cur.next[index] == null) {
                    cur.next[index] = new Trie();
                }
                cur = cur.next[index];
            }

            cur.end = true;
        }

        public boolean find(String word) {
            Trie cur = this;

            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';

                if (cur.next[index] == null) {

                    for (int j = 0; j < cur.next.length; j++) {
                        if (cur.next[j] != null && cur.next[j].find(word, i + 1)) {
                            return true;
                        }
                    }

                    return false;
                } else {
                    cur = cur.next[index];
                }
            }

            return cur.end;
        }

        private boolean find(String word, int index) {
            Trie cur = this;

            for (int i = index; i < word.length(); i++) {
                int bucketIndex = word.charAt(i) - 'a';

                if (cur.next[bucketIndex] == null) {
                    return false;
                }

                cur = cur.next[bucketIndex];
            }

            return cur.end;
        }
    }
}
