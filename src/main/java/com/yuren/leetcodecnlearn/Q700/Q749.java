package com.yuren.leetcodecnlearn.Q700;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q749 {
    private Set<Integer> seen;
    private List<Set<Integer>> regions;
    private List<Set<Integer>> frontiers;
    private List<Integer> perimeters;
    private int[][] grid;
    private int r, c;
    int[] dr = new int[]{-1, 1, 0, 0};
    int[] dc = new int[]{0, 0, -1, 1};

    public int containVirus(int[][] grid) {
        this.grid = grid;
        r = grid.length;
        c = grid[0].length;

        int ans = 0;
        while (true) {
            seen = new HashSet<>();
            regions = new ArrayList<>();
            frontiers = new ArrayList<>();
            perimeters = new ArrayList<>();

            for (int r = 0; r < this.r; ++r) {
                for (int c = 0; c < this.c; ++c) {
                    if (grid[r][c] == 1 && !seen.contains(r * this.c + c)) {
                        regions.add(new HashSet<>());
                        frontiers.add(new HashSet<>());
                        perimeters.add(0);
                        dfs(r, c);
                    }
                }
            }

            if (regions.isEmpty()) break;
            int triageIndex = 0;
            for (int i = 0; i < frontiers.size(); ++i) {
                if (frontiers.get(triageIndex).size() < frontiers.get(i).size())
                    triageIndex = i;
            }
            ans += perimeters.get(triageIndex);

            for (int i = 0; i < regions.size(); ++i) {
                if (i == triageIndex) {
                    for (int code : regions.get(i))
                        grid[code / c][code % c] = -1;
                } else {
                    for (int code : regions.get(i)) {
                        int r = code / this.c, c = code % this.c;
                        for (int k = 0; k < 4; ++k) {
                            int nr = r + dr[k], nc = c + dc[k];
                            if (nr >= 0 && nr < this.r && nc >= 0 && nc < this.c && grid[nr][nc] == 0) {
                                grid[nr][nc] = 1;
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }

    public void dfs(int r, int c) {
        if (!seen.contains(r * this.c + c)) {
            seen.add(r * this.c + c);
            int n = regions.size();
            regions.get(n - 1).add(r * this.c + c);
            for (int k = 0; k < 4; ++k) {
                int nr = r + dr[k], nc = c + dc[k];
                if (nr >= 0 && nr < this.r && nc >= 0 && nc < this.c) {
                    if (grid[nr][nc] == 1) {
                        dfs(nr, nc);
                    } else if (grid[nr][nc] == 0) {
                        frontiers.get(n - 1).add(nr * this.c + nc);
                        perimeters.set(n - 1, perimeters.get(n - 1) + 1);
                    }
                }
            }
        }
    }
}
