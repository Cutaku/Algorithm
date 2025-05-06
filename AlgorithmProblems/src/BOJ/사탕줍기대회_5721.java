package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사탕줍기대회_5721 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        while (n > 0) {
            int[] row = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());

                int[] col = new int[m + 1];
                col[1] = Integer.parseInt(st.nextToken());

                for (int j = 2; j <= m; j++) {
                    col[j] = Math.max(col[j - 2] + Integer.parseInt(st.nextToken()), col[j - 1]);
                }

                if (i > 1) {
                    row[i] = Math.max(row[i - 2] + col[m], row[i - 1]);
                } else {
                    row[i] = col[m];
                }
            }

            sb.append(row[n]).append("\n");

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
        }

        System.out.println(sb);
    }
}