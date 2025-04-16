package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이와가위_20444 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        if (n >= k) {
            System.out.println("NO");
            return;
        }

        long s = 0, e = n / 2;

        if ((e + 1) * (n - e + 1) == k) {
            System.out.println("YES");
            return;
        }

        while (e - s > 1) {
            long m = (s + e) / 2;

            if ((m + 1) * (n - m + 1) <= k) s = m;
            else e = m;
        }

        System.out.println((s + 1) * (n - s + 1) == k ? "YES" : "NO");
    }
}