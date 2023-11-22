package com.yuren.leetcodecnlearn.Q2000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-11-22 23:01
 */
public class Q2069 {
    String[] ss = new String[]{"East", "North", "West", "South"};
    int w, h, loc; // loc: 有效（取模后）移动步数
    boolean moved; // 记录是否经过移动，用于特判 (0,0) 的方向

    public Q2069(int width, int height) {
        w = width;
        h = height;
    }

    public void step(int num) {
        moved = true;
        loc += num;
        loc %= 2 * (w - 1) + 2 * (h - 1);
    }

    public int[] getPos() {
        int[] info = move();
        return new int[]{info[0], info[1]};
    }

    public String getDir() {
        int[] info = move();
        int x = info[0], y = info[1], dir = info[2];
        // 特殊处理当前在 (0,0) 的情况，当未移动过方向为 East，移动过方向为 South
        if (x == 0 && y == 0) return moved ? ss[3] : ss[0];
        return ss[dir];
    }

    int[] move() {
        if (loc <= w - 1) {
            // 当移动步数范围在 [0,w-1] 时，所在位置为外圈的下方，方向为 East
            return new int[]{loc, 0, 0};
        } else if (loc <= (w - 1) + (h - 1)) {
            // 当移动步数范围在 [w,(w-1)+(h-1)] 时，所在位置为外圈的右方，方向为 North
            return new int[]{w - 1, loc - (w - 1), 1};
        } else if (loc <= 2 * (w - 1) + (h - 1)) {
            // 当移动步数范围在 [(w-1)+(h-1)+1,2*(w-1)+(h-1)] 时，所在位置为外圈的上方，方向为 West
            return new int[]{(w - 1) - (loc - ((w - 1) + (h - 1))), h - 1, 2};
        } else {
            // 当移动步数范围在 [2*(w-1)+(h-1)+1,2*(w-1)+2*(h-1)] 时，所在位置为外圈的左方，方向为 South
            return new int[]{0, (h - 1) - (loc - (2 * (w - 1) + (h - 1))), 3};
        }
    }
}
