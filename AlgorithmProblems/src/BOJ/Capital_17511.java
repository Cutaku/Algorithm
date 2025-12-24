package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Capital_17511 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        boolean[] v = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            st.nextToken();
            v[Integer.parseInt(st.nextToken())] = true;
        }

        int cnt = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            if (!v[i]) {
                cnt++;
                sb.append(i).append(" ");
            }
        }

        System.out.println(cnt);
        System.out.println(sb);
    }
}