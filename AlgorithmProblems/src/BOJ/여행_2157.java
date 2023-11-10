package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class 여행_2157 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nmk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nmk[0], m = nmk[1], k = nmk[2];

        int[][] flights = new int[k][];

        for (int i = 0; i < k; i++) {
            flights[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        Arrays.sort(flights, Comparator.comparingInt(f -> f[0]));

        int[][] max = new int[n + 1][m];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(max[i], -1);
        }

        max[1][0] = 0;

        for (int[] flight : flights) {
            if (flight[0] > flight[1]) continue;

            for (int i = 1; i < m; i++) {
                if (max[flight[0]][i - 1] < 0) continue;

                max[flight[1]][i] = Math.max(max[flight[1]][i], max[flight[0]][i -1] + flight[2]);
            }
        }

        int ans = 0;

        for (int i = 1; i < m; i++) {
            ans = Math.max(ans, max[n][i]);
        }

        System.out.println(ans);
    }
}