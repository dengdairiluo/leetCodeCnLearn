package com.yuren.leetcodecnlearn.Q1900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-09-05 23:56
 */
public class Q1904 {
    public int numberOfRounds(String loginTime, String logoutTime) {
        int[] login = this.time(loginTime);
        int[] logout = this.time(logoutTime);
        // 最近大，调整到最近一个开始的起点，顺时针调整时间
        this.ceiling(login);
        // 最近小，调整到最近一个结束的终点，逆时针调整时间
        this.floor(logout);
        if (loginTime.compareTo(logoutTime) < 0) {
            // 同一天
            return Math.max(round24(login) - round24(logout), 0);//wa2
        } else {
            // 不同天
            return round24(login) + round00(logout);
        }
    }

    // 玩到0点能玩几局
    private int round24(int[] time) {
        return ((23 - time[0]) << 2) + this.round(time[1]);
    }

    // 从0点玩能玩几局
    private int round00(int[] time) {
        return (time[0] << 2) + 4 - this.round(time[1]);
    }

    // 玩到下一个整点能玩几局
    private int round(int minute) {
        if (minute == 0) {
            return 4;
        }
        if (minute == 15) {
            return 3;
        }
        if (minute == 30) {
            return 2;
        }
        return 1;
    }

    // 最近小
    private void floor(int[] time) {
        int minute = time[1];
        if (minute == 0 || minute == 15 || minute == 30 || minute == 45) {
            return;
        }
        if (minute < 15) {
            time[1] = 0;
            return;
        }
        if (minute < 30) {
            time[1] = 15;
            return;
        }
        if (minute < 45) {
            time[1] = 30;
            return;
        }
        time[1] = 45;
    }

    // 最近大
    private void ceiling(int[] time) {
        int minute = time[1];
        if (minute == 0 || minute == 15 || minute == 30 || minute == 45) {
            return;
        }
        if (minute < 15) {
            time[1] = 15;
            return;
        }
        if (minute < 30) {
            time[1] = 30;
            return;
        }
        if (minute < 45) {
            time[1] = 45;
            return;
        }
        time[1] = 0;
        time[0] += 1;// wa1!!!!
    }

    private int[] time(String time) {
        return new int[]{Integer.parseInt(time.substring(0, 2)), Integer.parseInt(time.substring(3, 5))};
    }

}
