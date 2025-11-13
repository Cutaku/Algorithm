package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 와드_23747 {
    static int r, c;
    static int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static char[][] map;
    static boolean[][] sight;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][];
        for (int i = 0; i < r; i++) map[i] = br.readLine().toCharArray();

        sight = new boolean[r][c];

        st = new StringTokenizer(br.readLine());
        int hr = Integer.parseInt(st.nextToken()) - 1;
        int hc = Integer.parseInt(st.nextToken()) - 1;

        String path = br.readLine();

        for (int i = 0; i < path.length(); i++) {
            switch (path.charAt(i)) {
                case 'L':
                    hc--;
                    break;
                case 'R':
                    hc++;
                    break;
                case 'U':
                    hr--;
                    break;
                case 'D':
                    hr++;
                    break;
                default:
                    ward(hr, hc);
            }
        }

        sight[hr][hc] = true;

        for (int[] d : D) {
            int x = hr + d[0];
            int y = hc + d[1];

            if (x < 0 || y < 0 || x >= r || y >= c) continue;

            sight[x][y] = true;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sb.append(sight[i][j] ? "." : "#");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void ward(int x, int y) {

        Queue<int[]> q = new ArrayDeque<>();

        char a = map[x][y];

        if (a == '.') return;

        q.add(new int[] {x, y});
        map[x][y] = '.';

        while (!q.isEmpty()) {
            int[] now = q.poll();

            sight[now[0]][now[1]] = true;

            for (int[] d : D) {
                int nx = now[0] + d[0];
                int ny = now[1] + d[1];

                if (nx < 0 || ny < 0 || nx >= r || ny >= c || map[nx][ny] != a) continue;

                q.add(new int[] {nx, ny});
                map[nx][ny] = '.';
            }
        }
    }
}