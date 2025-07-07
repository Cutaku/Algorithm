package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기차표검사_3167 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        int a = 0;
        int c = 0, d = 0;

        int min = 0, max = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int M = Math.min(a, x);
            a -= M;
            max += M;

            int m = Math.min(d, x);
            c -= x - m;
            d -= m;
            min += x - m;

            a += y;
            c += y;

            if (i % k == 0) {
                d += c;
                a = 0;
                c = 0;
            }
        }

        System.out.println(min + " " + max);
    }
}