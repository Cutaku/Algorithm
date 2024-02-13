package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FlymetotheAlphaCentauri_1011 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());


        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            int d = Math.abs(Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken()));

            int n = 1;

            int ans = 1;

            d--;

            while (d > 0) {
                if (d > 2 * n) {
                    d -= 2 * n + 1;
                    ans += 2;
                    n++;
                } else {
                    d -= n;
                    ans++;
                }
            }

            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }
}