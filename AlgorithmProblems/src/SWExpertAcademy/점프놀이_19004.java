package SWExpertAcademy;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 점프놀이_19004 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            bw.append("#").append(String.valueOf(tc)).append(" ");

            int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = nk[0], k = nk[1];

            int[][] art = new int[n][];
            for (int i = 0; i < n; i++) art[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            List<int[]>[] list = new List[k + 1];
            for (int i = 1; i <= k; i++) list[i] = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    list[art[i][j]].add(new int[]{i, j});
                }
            }

            boolean stop = false;

            for (int i = 1; i <= k; i++) {
                if (list[i].size() == 0) {
                    stop = true;
                    bw.append("-1\n");
                    break;
                }
            }

            if (stop) continue;

            int[][] dp = new int[n][n];
            for (int i = 0; i < n; i++) Arrays.fill(dp[i], k * 100);

            for (int[] p : list[1]) {
                dp[p[0]][p[1]] = 0;
            }

            for (int i = 1; i < k; i++) {
                for (int[] from : list[i]) {
                    for (int[] to : list[i + 1]) {
                        dp[to[0]][to[1]] = Math.min(dp[to[0]][to[1]], dp[from[0]][from[1]] + Math.abs(from[0] - to[0]) + Math.abs(from[1] - to[1]));
                    }
                }
            }

            int min = k * 100;

            for (int[] p : list[k]) {
                min = Math.min(min, dp[p[0]][p[1]]);
            }

            bw.append(String.valueOf(min)).append("\n");
        }

        bw.flush();
    }
}