package com.yuren.leetcodecnlearn.Q1100;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-11-23 23:35
 */
public class Q1169 {
    public List<String> invalidTransactions(String[] transactions) {
        List<String> res = Collections.unmodifiableList(new ArrayList<>());
        Map<String, List<Txn>> txnMap = new HashMap<>();
        for (String txn : transactions) {
            Txn newTxn = new Txn(txn);
            List<Txn> l = txnMap.getOrDefault(newTxn.name, new ArrayList<>());
            l.add(newTxn);
            txnMap.put(newTxn.name, l);
        }

        for (List<Txn> l : txnMap.values()) {
            for (Txn t : l) {
                if (!isValid(t, l)) {
                    res.add(t.info); // found an invalid transaction
                }
            }
        }

        return res;
    }

    private boolean isValid(Txn t, List<Txn> l) {
        if (t.amount > 1000) return false;
        for (Txn t2 : l) {
            if (t == t2) continue;
            if (Math.abs(t.time - t2.time) <= 60 && !t.city.equals(t2.city)) return false;
        }
        return true;
    }

    private class Txn {
        String name;
        int time;
        int amount;
        String city;
        String info; // original string

        public Txn(String txn) {
            String[] parts = txn.split(",");
            name = parts[0];
            time = Integer.parseInt(parts[1]);
            amount = Integer.parseInt(parts[2]);
            city = parts[3];
            info = txn;
        }
    }
}
