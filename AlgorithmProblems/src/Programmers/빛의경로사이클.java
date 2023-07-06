package Programmers;

import java.util.*;

class 빛의경로사이클 {
    public int[] solution(String[] grid) {

        int n = grid.length;
        int m = grid[0].length();

        boolean[][][] visited = new boolean[n][m][4];

        List<Integer> list = new ArrayList<>();

        int[][] D = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 4; k++) {
                    if (visited[i][j][k]) continue;

                    int x = i;
                    int y = j;
                    int d = k;

                    int count = 0;

                    while (!visited[x][y][d]) {
                        count++;

                        visited[x][y][d] = true;

                        x = (x + D[d][0] + n) % n;
                        y = (y + D[d][1] + m) % m;

                        switch (grid[x].charAt(y)) {
                            case 'L':
                                d = (d + 1) % 4;
                                break;
                            case 'R':
                                d = (d + 3) % 4;
                                break;
                        }
                    }

                    list.add(count);
                }
            }
        }

        int[] ans = new int[list.size()];

        for (int i = 0; i < list.size(); i++) ans[i] = list.get(i);

        Arrays.sort(ans);

        return ans;
    }
}