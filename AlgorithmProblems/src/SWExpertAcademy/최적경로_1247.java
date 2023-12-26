package SWExpertAcademy;

import java.io.*;
import java.util.Arrays;

public class 최적경로_1247 {
    static int n;
    static int[] house;
    static int[][] customers;
    static boolean[] visited;
    static int min;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());

            int[] positions = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int[] workplace = new int[2];
            workplace[0] = positions[0];
            workplace[1] = positions[1];

            house = new int[2];
            house[0] = positions[2];
            house[1] = positions[3];

            customers = new int[n][2];

            for (int i = 0; i < n; i++) {
                customers[i][0] = positions[4 + i * 2];
                customers[i][1] = positions[5 + i * 2];
            }

            visited = new boolean[n + 1];

            min = Integer.MAX_VALUE;

            dfs(workplace, 0, 0);

            bw.append("#").append(String.valueOf(t)).append(" ").append(String.valueOf(min)).append("\n");
        }

        bw.flush();
    }

    public static void dfs(int[] last, int sum, int d) {

        if (d == n) {
            min = Math.min(min, sum + distance(house, last));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            visited[i] = true;

            dfs(customers[i], sum + distance(last, customers[i]), d + 1);

            visited[i] = false;
        }
    }

    public static int distance(int[] p1, int[] p2) {

        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}