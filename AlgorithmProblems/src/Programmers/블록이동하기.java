package Programmers;

import java.util.*;

class 블록이동하기 {
    public int solution(int[][] board) {

        int n = board.length;

        int[][] visited = new int[n][];
        for (int i = 0; i < n; i++) visited[i] = new int[n];

        for (int i = 0; i < n; i++) {
            visited[i][n - 1] += 1;
            visited[n - 1][i] += 2;
        }

        Queue<int[]> q1 = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();

        q1.add(new int[] {0, 0, 0});
        visited[0][0] += 1;

        int[][] D = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        int count = 0;

        while (!q1.isEmpty()) {

            int[] now = q1.poll();

            if (now[0] == n - 1 && now[1] == n - 2 && now[2] == 0) break;
            if (now[0] == n - 2 && now[1] == n - 1 && now[2] == 1) break;

            for (int[] d : D) {
                int x = now[0] + d[0];
                int y = now[1] + d[1];

                if (x < 0 || y < 0 || x >= n || y >= n) continue;

                if (now[2] == 0) {
                    if (visited[x][y] % 2 == 0 && board[x][y] == 0 && board[x][y + 1] == 0) {
                        visited[x][y] += 1;
                        q2.add(new int[] {x, y, 0});
                    }
                } else {
                    if (visited[x][y] / 2 == 0 && board[x][y] == 0 && board[x + 1][y] == 0) {
                        visited[x][y] += 2;
                        q2.add(new int[] {x, y, 1});
                    }
                }
            }

            int x = now[0], y = now[1];

            if (now[2] == 0) {
                if (x < n - 1 && board[x + 1][y] == 0 && board[x + 1][y + 1] == 0) {
                    if (visited[x][y] / 2 == 0) {
                        visited[x][y] += 2;
                        q2.add(new int[] {x, y, 1});
                    }

                    if (visited[x][y + 1] / 2 == 0) {
                        visited[x][y + 1] += 2;
                        q2.add(new int[] {x, y + 1, 1});
                    }
                }

                if (x > 0 && board[x - 1][y] == 0 && board[x - 1][y + 1] == 0) {
                    if (visited[x - 1][y] / 2 == 0) {
                        visited[x - 1][y] += 2;
                        q2.add(new int[] {x - 1, y, 1});
                    }

                    if (visited[x - 1][y + 1] / 2 == 0) {
                        visited[x - 1][y + 1] += 2;
                        q2.add(new int[] {x - 1, y + 1, 1});
                    }
                }
            } else if (now[2] == 1) {
                if (y < n - 1 && board[x][y + 1] == 0 && board[x + 1][y + 1] == 0) {
                    if (visited[x][y] % 2 == 0) {
                        visited[x][y] += 1;
                        q2.add(new int[] {x, y, 0});
                    }

                    if (visited[x + 1][y] % 2 == 0) {
                        visited[x + 1][y] += 1;
                        q2.add(new int[] {x + 1, y, 0});
                    }
                }

                if (y > 0 && board[x][y - 1] == 0 && board[x + 1][y - 1] == 0) {
                    if (visited[x][y - 1] % 2 == 0) {
                        visited[x][y - 1] += 1;
                        q2.add(new int[] {x, y - 1, 0});
                    }

                    if (visited[x + 1][y - 1] % 2 == 0) {
                        visited[x + 1][y - 1] += 1;
                        q2.add(new int[] {x + 1, y - 1, 0});
                    }
                }
            }

            if (q1.isEmpty()) {
                q1 = q2;
                q2 = new LinkedList<>();
                count++;
            }
        }

        return count;
    }
}
