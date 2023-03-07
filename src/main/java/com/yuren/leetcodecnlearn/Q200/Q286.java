package com.yuren.leetcodecnlearn.Q200;

import java.util.ArrayDeque;
import java.util.Queue;

public class Q286 {
    final int DOOR = 0;
    final int EMPTY = Integer.MAX_VALUE;

    int[][] directions = new int[][]{
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };
    int rows;
    int cols;

    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> doors = new ArrayDeque<>();
        rows = rooms.length;
        cols = rooms[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rooms[i][j] == DOOR) {
                    doors.add(new int[]{i, j});
                }
            }
        }
        while (!doors.isEmpty()) {
            int[] point = doors.poll();
            for (int[] dir : directions) {
                int r = point[0] + dir[0], c = point[1] + dir[1];
                if (inRooms(r, c) && rooms[r][c] == EMPTY) {
                    rooms[r][c] = rooms[point[0]][point[1]] + 1;
                    doors.add(new int[]{r, c});
                }
            }
        }
    }

    public boolean inRooms(int r, int c) {
        return r >= 0 && c >= 0 && r < rows && c < cols;
    }
}
