package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기차여행_10713 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        int[] city = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) city[i] = Integer.parseInt(st.nextToken());

        long[] use = new long[n];
        for (int i = 0; i < m - 1; i++) {
            use[Math.min(city[i], city[i + 1]) - 1]++;
            use[Math.max(city[i], city[i + 1]) - 1]--;
        }

        for (int i = 1; i < n; i++) {
            use[i] += use[i - 1];
        }

        long ans = 0;

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            ans += Math.min(a * use[i], c + b * use[i]);
        }

        System.out.println(ans);
    }
}