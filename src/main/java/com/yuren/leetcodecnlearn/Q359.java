package com.yuren.leetcodecnlearn;

import java.util.HashMap;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-05-22 21:57
 */
public class Q359 {

    private final HashMap<String, Integer> msgDict;

    /**
     * Initialize your data structure here.
     */
    public Q359() {
        msgDict = new HashMap<>();
    }

    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns false.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {

        if (!this.msgDict.containsKey(message)) {
            this.msgDict.put(message, timestamp);
            return true;
        }

        Integer oldTimestamp = this.msgDict.get(message);
        if (timestamp - oldTimestamp >= 10) {
            this.msgDict.put(message, timestamp);
            return true;
        } else {
            return false;
        }
    }

}
