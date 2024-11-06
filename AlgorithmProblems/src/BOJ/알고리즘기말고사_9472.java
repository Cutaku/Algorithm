package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알고리즘기말고사_9472 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        long[] fact = new long[18];
        fact[0] = 1;

        for (int i = 1; i < 18; i++) {
            fact[i] = fact[i - 1] * i;
        }

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

            long ans = 0;

            for (int i = 0; i <= k; i++) {
                ans += ((i % 2 == 0) ? 1 : -1) * fact[n - i] * (fact[k] / fact[i] / fact[k - i]);
            }

            sb.append(t).append(" ").append(ans).append("\n");
        }

        System.out.println(sb);
    }
}