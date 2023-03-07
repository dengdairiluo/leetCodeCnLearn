package com.yuren.leetcodecnlearn.Q400;

import java.util.HashMap;
import java.util.Map;

class Q460 {


    Frequency head;
    Frequency tail;
    Map<Integer, Time> hash;
    int capacity;
    int size;

    public Q460(int capacity) {
        head = new Frequency();
        tail = new Frequency();
        head.next = tail;// 建立频率的首尾关系
        tail.last = head;
        hash = new HashMap<>();
        this.capacity = capacity;// 容量限制
        this.size = 0;// 当前数量
    }

    // 如果键 key 存在于缓存中，则获取键的值，否则返回 -1
    public int get(int key) {
        Time ans = hash.getOrDefault(key, null);
        if (ans == null) {
            return -1;// 否则返回 -1
        }
        // 调整key的顺序,对缓存中的键执行 get 或 put 操作，使用计数器的值将会递增。
        ans.updateFrequency();
        return ans.value;// 存在于缓存中
    }

    // 如果键 key 已存在，则变更其值；
    // 如果键不存在，请插入键值对。
    // 当缓存达到其容量 capacity 时，则应该在插入新项之前，移除最不经常使用的项。
    // 在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最近最久未使用 的键。
    public void put(int key, int value) {
        if (this.capacity == 0) {
            return;
        }
        Time time = hash.getOrDefault(key, null);
        if (time == null) {// 新来的
            if (this.size == this.capacity) {
                Integer removeKey = head.remove();
                if (removeKey != null) this.hash.remove(removeKey);
            } else {
                this.size += 1;
            }
            time = new Time(key, value, head);
            hash.put(key, time);// 不要忘了put
        } else {
            time.value = value;
            time.updateFrequency();
        }
    }

    class Frequency {
        int count;
        Frequency last;
        Frequency next;
        Time head;
        Time tail;
        int size;// 用于取消词频

        public Frequency() {
            count = 0;
            head = null;
            tail = null;
            size = 0;// 可以是1为了head不被删掉减少一个if判断
        }

        public Frequency(int count) {
            this.count = count;
            this.head = new Time();
            this.tail = new Time();
            this.head.next = this.tail;
            this.tail.last = this.head;
            this.size = 0;
        }

        public Integer remove() {
            return this.next.count == 0 ? null : this.next.removeTime();
        }

        private int removeTime() {
            Time ans = this.head.next;
            Time tmp = ans.next;
            this.head.next = tmp;
            tmp.last = this.head;
            this.size -= 1;// remove time当前size -1
            return ans.key;
        }

        // 更新词频
        public Frequency updateFrequency(Time time) {
            // 将待移动的time从当前的head<->tail中摘出来
            this.pickUp(time);
            // 交给下一个词频
            this.size -= 1;
            return this.move2next(time);
        }

        // 交给下一个词频
        private Frequency move2next(Time time) {
            int nextCount = this.count + 1;
            if (this.next.count == nextCount) {
                this.next.addTime(time);
                return this.next;
            } else {
                Frequency add = this.addFrequency(nextCount);
                add.addTime(time);
                return add;
            }
        }

        private void addTime(Time time) {
            Time tmp = this.tail.last;
            tmp.next = time;
            time.last = tmp;
            time.next = this.tail;
            this.tail.last = time;
            this.size += 1;
            this.checkFrequency();
        }

        private void checkFrequency() {
            if (this.last.count != 0 && this.last.size == 0) {
                Frequency tmp = this.last.last;
                tmp.next = this;
                this.last = tmp;
            }
        }

        private Frequency addFrequency(int nextCount) {
            Frequency ans = new Frequency(nextCount);
            Frequency tail = this.next;
            this.next = ans;
            ans.last = this;
            ans.next = tail;
            tail.last = ans;
            return ans;
        }

        // 从当前的head<->tail中摘出time来
        private void pickUp(Time time) {
            // 摘出time
            time.last.next = time.next;
            time.next.last = time.last;
            time.next = null;
            time.last = null;
        }

    }

    class Time {
        Time last;
        Time next;
        int key;
        int value;
        Frequency frequency;

        public Time() {

        }

        public Time(int key, int value, Frequency head) {
            this.key = key;
            this.value = value;
            this.frequency = head.move2next(this);// 创建所属词频
        }

        public void updateFrequency() {
            this.frequency = this.frequency.updateFrequency(this);// 更新词频
        }
    }


}

