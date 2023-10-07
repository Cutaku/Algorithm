package BOJ;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 녹색옷입은애가젤다지_4485 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int p = 1;

        int[][] D = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                bw.flush();
                return;
            }

            int[][] cave = new int[n][];
            for (int i = 0; i < n; i++) cave[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            boolean[][] checked = new boolean[n][n];

            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));

            pq.add(new int[]{0, 0, cave[0][0]});

            int min = 0;

            while (!pq.isEmpty()) {
                int[] now = pq.poll();

                if (checked[now[0]][now[1]]) continue;

                if (now[0] == n - 1 && now[1] == n - 1) {
                    min = now[2];
                    break;
                }

                checked[now[0]][now[1]] = true;

                for (int[] d : D) {
                    int x = now[0] + d[0];
                    int y = now[1] + d[1];

                    if (x < 0 || y < 0 || x >= n || y >= n || checked[x][y]) continue;

                    pq.add(new int[]{x, y, now[2] + cave[x][y]});
                }
            }

            bw.append("Problem ");
            bw.append(String.valueOf(p++));
            bw.append(": ");
            bw.append(String.valueOf(min));
            bw.append("\n");
        }
    }
}