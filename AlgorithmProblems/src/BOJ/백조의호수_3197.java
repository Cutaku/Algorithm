package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백조의호수_3197 {
    static int r, c;
    static char[][] map;
    static int[][] group;
    static int[][] time;
    static int[] roots = new int[2250001];
    static int[][] D = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][];
        for (int i = 0; i < r; i++) map[i] = br.readLine().toCharArray();

        Queue<int[]> q1 = new ArrayDeque<>();
        Queue<int[]> q2 = new ArrayDeque<>();

        group = new int[r][c];
        time = new int[r][c];
        int g = 1;

        int[] p = new int[2];
        int pi = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] != 'X' && map[i][j] != 'O') {
                    if (map[i][j] == 'L') p[pi++] = g;

                    group[i][j] = g;
                    map[i][j] = 'O';

                    q1.add(new int[]{i, j, g});

                    while (!q1.isEmpty()) {
                        int[] now = q1.poll();

                        for (int[] d : D) {
                            int x = now[0] + d[0];
                            int y = now[1] + d[1];

                            if (x < 0 || y < 0 || x >= r || y >= c || map[x][y] == 'O') continue;

                            if (map[x][y] == 'L') {
                                if (map[x][y] == 'L') p[pi++] = g;
                                q1.add(new int[]{x, y, g});
                            } else if (map[x][y] == '.') {
                                q1.add(new int[]{x, y, g});
                            } else {
                                q2.add(new int[]{x, y, g});
                                time[x][y] = 1;
                            }

                            group[x][y] = g;
                            map[x][y] = 'O';
                        }
                    }

                    roots[g] = g;
                    g++;
                }
            }
        }

        if (p[0] == p[1]) {
            System.out.println(0);
            return;
        }

        q1 = q2;
        q2 = new ArrayDeque<>();

        while (!q1.isEmpty()) {
            int[] now = q1.poll();

            for (int[] d : D) {
                int x = now[0] + d[0];
                int y = now[1] + d[1];

                if (x < 0 || y < 0 || x >= r || y >= c) continue;

                if (map[x][y] == 'X') {
                    q2.add(new int[]{x, y, now[2]});
                    map[x][y] = 'O';
                    group[x][y] = now[2];
                    time[x][y] = time[now[0]][now[1]] + 1;
                } else if (roots[group[x][y]] != roots[now[2]]) {
                    int a = find(group[x][y]);
                    int b = find(now[2]);

                    if (a > b) {
                        int t = a;
                        a = b;
                        b = t;
                    }

                    roots[b] = a;

                    if (find(p[0]) == find(p[1])) {
                        System.out.println(Math.max(time[now[0]][now[1]], time[x][y]));
                        return;
                    }
                }
            }

            if (q1.isEmpty()) {
                Queue<int[]> temp = q1;
                q1 = q2;
                q2 = temp;
            }
        }
    }

    static int find(int x) {
        if (x == roots[x]) return x;
        return roots[x] = find(roots[x]);
    }
}