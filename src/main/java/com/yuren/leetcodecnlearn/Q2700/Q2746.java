package com.yuren.leetcodecnlearn.Q2700;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-10-27 23:59
 */
public class Q2746 {
    static final int INF = 1_000_000_007;
    public int minimizeConcatenatedLength(String[] words) {
        int leftDiff = 0;
        int rightDiff = 0;
        int[] tails = new int[26];
        int[] heads = new int[26];

        Arrays.fill(heads, -INF);
        Arrays.fill(tails, -INF);

        int total = words[0].length();
        int preHead = words[0].charAt(0) - 'a';
        int preTail = words[0].charAt(total - 1) - 'a';

        heads[preHead] = 0;
        tails[preTail] = 0;

        int curHead, curTail, wordLength, rightDiffOld, leftDiffOld, tailBestOld, headBestOld, tailsNewPre, headsNewPre;
        int headBest = 0, tailBest = 0;
        String word;

        for (int i = 1; i < words.length; i++) {
            word = words[i];
            wordLength = word.length();
            curHead = word.charAt(0) - 'a';
            curTail = word.charAt(wordLength - 1) - 'a';
            rightDiffOld = rightDiff;
            leftDiffOld = leftDiff;
            tailBestOld = tailBest;
            headBestOld = headBest;

            leftDiff += curTail == preHead ? 1 : 0;
            tailsNewPre = Math.max(rightDiffOld + tailBestOld - leftDiff, rightDiffOld + heads[curTail] + 1 - leftDiff);
            headBest = Math.max(headBestOld, tailsNewPre);

            rightDiff += curHead == preTail ? 1 : 0;
            headsNewPre = Math.max(leftDiffOld + headBestOld - rightDiff, leftDiffOld + tails[curHead] + 1 - rightDiff);
            tailBest = Math.max(headsNewPre, tailBestOld);

            tails[preTail] = Math.max(tails[preTail], tailsNewPre);
            heads[preHead] = Math.max(heads[preHead], headsNewPre);

            preHead = curHead;
            preTail = curTail;

            total += wordLength;
        }

        return total - Math.max(leftDiff + headBest, rightDiff + tailBest);
    }
}
