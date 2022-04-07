package com.yuren.leetcodecnlearn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-04-07 23:24
 */
public class Q635 {
    LinkedList<Record> records = new LinkedList<Q635.Record>();

    public Q635() {

    }

    public void put(int id, String timestamp) {
        records.add(new Record(id, timestamp));
    }

    public List<Integer> retrieve(String s, String e, String gra) {
        List<Integer> list = new ArrayList<>();
        for (Record record : records) {
            if (record.compare(s, gra) >= 0 && record.compare(e, gra) <= 0) {
                list.add(record.id);
            }
        }
        return list;
    }

    private static class Record {
        static final String YEAR_STRING = "Year";
        static final String MONTH_STRING = "Month";
        static final String DAY_STRING = "Day";
        static final String HOUR_STRING = "Hour";
        static final String MINUTE_STRING = "Minute";
        static final String SECOND_STRING = "Second";

        int id;
        String timestamp;

        public Record(int id, String timestamp) {
            this.id = id;
            this.timestamp = timestamp;
        }

        public int compare(String timestamp, String string) {
            switch (string) {
                case YEAR_STRING:
                    return this.timestamp.substring(0, 4).compareToIgnoreCase(timestamp.substring(0, 4));
                case MONTH_STRING:
                    return this.timestamp.substring(0, 7).compareToIgnoreCase(timestamp.substring(0, 7));
                case DAY_STRING:
                    return this.timestamp.substring(0, 10).compareToIgnoreCase(timestamp.substring(0, 10));
                case HOUR_STRING:
                    return this.timestamp.substring(0, 13).compareToIgnoreCase(timestamp.substring(0, 13));
                case MINUTE_STRING:
                    return this.timestamp.substring(0, 16).compareToIgnoreCase(timestamp.substring(0, 16));
                case SECOND_STRING:
                    return this.timestamp.compareToIgnoreCase(timestamp);
                default:
                    System.out.println("error");
                    break;
            }

            return 0;
        }

    }
}
