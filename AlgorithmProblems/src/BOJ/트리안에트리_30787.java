package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 트리안에트리_30787 {
    static int d = 1000000007;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        long ans = 0;
        long p = 1;

        for (int i = 0; i <= n - k; i++) {
            if (i >= k) {
                ans = (ans + 3 * p) % d;
            } else {
                ans = (ans + p) % d;
            }

            p = 2 * p % d;
        }

        System.out.println(ans);
    }
}