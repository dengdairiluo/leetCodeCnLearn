package com.yuren.leetcodecnlearn.Q1800;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-07-29 22:21
 */
public class Q1804 {
    Q1804[] children = new Q1804[26];
    int count;
    int prefixCount;

    public Q1804() {
    }

    public void insert(String word) {
        Q1804 curr = this;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new Q1804();
            }
            curr = curr.children[index];
            ++curr.prefixCount;
        }

        ++curr.count;
    }

    public int countWordsEqualTo(String word) {
        Q1804 curr = search(word);
        return curr == null ? 0 : curr.count;
    }

    public int countWordsStartingWith(String prefix) {
        Q1804 curr = search(prefix);
        return curr == null ? 0 : curr.prefixCount;
    }

    public void erase(String word) {
        Q1804 curr = this;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            curr = curr.children[index];
            --curr.prefixCount;
        }
        --curr.count;
    }

    private Q1804 search(String word) {
        Q1804 curr = this;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) {
                return null;
            }
            curr = curr.children[index];
        }
        return curr;
    }
}
