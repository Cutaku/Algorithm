package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이로몇번나누어질까_1407 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken()) - 1, b = Long.parseLong(st.nextToken());

        long c = 1;
        long ans = 0;

        while (b >= c) {
            ans += ((b + c) / (c << 1) - (a + c) / (c << 1)) * c;
            c <<= 1;
        }

        System.out.println(ans);
    }
}