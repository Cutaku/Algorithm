package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class 점프게임_15558 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[2][n];

        String l = br.readLine();
        String r = br.readLine();

        for (int i = 0; i < n; i++) {
            map[0][i] = l.charAt(i) == '1';
            map[1][i] = r.charAt(i) == '1';
        }

        int[][] v = new int[2][n];

        Arrays.fill(v[0], Integer.MAX_VALUE);
        Arrays.fill(v[1], Integer.MAX_VALUE);

        Queue<int[]> q1 = new ArrayDeque<>();
        Queue<int[]> q2 = new ArrayDeque<>();

        q1.add(new int[]{0, 0});
        v[0][0] = 0;

        int t = 0;

        while (!q1.isEmpty()) {
            int[] now = q1.poll();

            if (now[1] + k >= n) {
                System.out.println(1);
                return;
            }

            if (map[now[0]][now[1] + 1] && v[now[0]][now[1] + 1] > t + 1) {
                q2.add(new int[]{now[0], now[1] + 1});
                v[now[0]][now[1] + 1] = t + 1;
            }

            if (now[1] > 0 && map[now[0]][now[1] - 1] && t < now[1] - 1 && v[now[0]][now[1] - 1] > t + 1) {
                q2.add(new int[]{now[0], now[1] - 1});
                v[now[0]][now[1] - 1] = t + 1;
            }

            if (map[1 - now[0]][now[1] + k] && v[1 - now[0]][now[1] + k] > t + 1) {
                q2.add(new int[]{1 - now[0], now[1] + k});
                v[1 - now[0]][now[1] + k] = t + 1;
            }

            if (q1.isEmpty()) {
                Queue<int[]> temp = q1;
                q1 = q2;
                q2 = temp;

                t++;
            }
        }

        System.out.println(0);
    }
}