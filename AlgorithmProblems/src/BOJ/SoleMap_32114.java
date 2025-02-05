package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SoleMap_32114 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        int[] w = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) w[i] = Integer.parseInt(st.nextToken());

        int[] sum = new int[n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken()) - 1, v = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken());

            sum[u] += x;
            sum[v] -= x;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n - 1; i++) {
            sum[i + 1] += sum[i];

            long q = sum[i] / w[i], r = sum[i] % w[i];
            sb.append((q + 1) * (q + 1) * r + (w[i] - r) * q * q).append("\n");
        }

        System.out.println(sb);
    }
}