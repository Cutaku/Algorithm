package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 떡장수와호랑이_16432 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int[][] rCakes = new int[n][];
        int[][] before = new int[n][];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());

            rCakes[i] = new int[m];
            before[i] = new int[m];

            for (int j = 0; j < m; j++) rCakes[i][j] = Integer.parseInt(st.nextToken());
        }

        if (n == 1) {
            System.out.println(rCakes[0][0]);
            return;
        }

        for (int i = n - 1; i > 0; i--) {
            int[] now = rCakes[i];
            int[] next = rCakes[i - 1];

            for (int j = 0; j < now.length; j++) {
                for (int k = 0; k < next.length; k++) {
                    if ((before[i][j] > 0 || i == n - 1) && now[j] != next[k]) before[i - 1][k] = j + 1;
                }
            }
        }

        int idx = -1;

        for (int i = 0; i < rCakes[0].length; i++) {
            if (before[0][i] > 0) {
                idx = i;
                break;
            }
        }

        if (idx == -1) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                sb.append(rCakes[i][idx]).append("\n");
                idx = before[i][idx] - 1;
            }

            System.out.println(sb);
        }
    }
}