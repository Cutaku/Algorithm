package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 가운데에서만나기_21940 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], 300000);
            dist[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1, b = Integer.parseInt(st.nextToken()) - 1;
            int t = Integer.parseInt(st.nextToken());

            dist[a][b] = Math.min(dist[a][b], t);
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (i == k) continue;

                for (int j = 0; j < n; j++) {
                    if (j == k || j == i) continue;

                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int k = Integer.parseInt(br.readLine());
        int[] cities = new int[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) cities[i] = Integer.parseInt(st.nextToken()) - 1;

        int min = 600000;
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int max = 0;

            for (int j = 0; j < k; j++) {
                max = Math.max(max, dist[i][cities[j]] + dist[cities[j]][i]);
            }

            if (max < min) {
                min = max;
                ans = new ArrayList<>();
                ans.add(i + 1);
            } else if (max == min) {
                ans.add(i + 1);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int a : ans) {
            sb.append(a).append(" ");
        }

        System.out.println(sb);
    }
}