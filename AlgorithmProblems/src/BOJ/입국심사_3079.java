package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 입국심사_3079 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        int[] times = new int[n];
        for (int i = 0; i < n; i++) times[i] = Integer.parseInt(br.readLine());

        long s = 0;
        long e = 1_000_000_000_000_000_000L;

        a: while (e - s > 1) {
            long c = (s + e) >> 1;

            long sum = 0;

            for (int time : times) {
                sum += c / time;
                if (sum >= m) {
                    e = c;
                    continue a;
                }
            }

            s = c;
        }

        System.out.println(e);
    }
}