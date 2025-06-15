package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 신비로운수_17433 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int last = Integer.parseInt(st.nextToken());

            int gcd = 0;

            for (int i = 1; i < n; i++) {
                int a = Integer.parseInt(st.nextToken());
                int d = Math.abs(a - last);

                gcd = gcd(gcd, d);
                last = a;
            }

            if (gcd > 0) sb.append(gcd).append("\n");
            else sb.append("INFINITY\n");
        }

        System.out.println(sb);
    }

    static int gcd(int a, int b) {

        while (b > 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }

        return a;
    }
}