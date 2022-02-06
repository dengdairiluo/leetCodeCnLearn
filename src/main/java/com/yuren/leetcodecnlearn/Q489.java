package com.yuren.leetcodecnlearn;

import java.util.HashSet;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-02-01 23:26
 */
public class Q489 {

    // the order of the directions matters
    private final int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public void cleanRoom(Robot robot) {
        HashSet<String> visited = new HashSet<>();
        int[] cur = new int[]{0, 0};
        dfs(robot, cur, 0, visited);
    }

    private void dfs(Robot robot, int[] cur, int dir, HashSet<String> visited) {
        robot.clean();
        visited.add(cur[0] + "-" + cur[1]);
        for (int i = 0; i < dirs.length; i++) {
            int nextDir = (dir + i) % 4;
            int[] next = new int[]{cur[0] + dirs[nextDir][0], cur[1] + dirs[nextDir][1]};
            if (!visited.contains(next[0] + "-" + next[1]) && robot.move()) {
                dfs(robot, next, nextDir, visited);
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnLeft();
            } else {
                robot.turnRight();
            }
        }
    }

    interface Robot {
        // Returns true if the cell in front is open and robot moves into the cell.
        // Returns false if the cell in front is blocked and robot stays in the current cell.
        boolean move();

        // Robot will stay in the same cell after calling turnLeft/turnRight.
        // Each turn will be 90 degrees.
        void turnLeft();

        void turnRight();

        // Clean the current cell.
        void clean();
    }
}


