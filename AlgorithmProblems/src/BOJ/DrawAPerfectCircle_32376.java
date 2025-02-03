package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DrawAPerfectCircle_32376 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        long[] distances = new long[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken()), b = Long.parseLong(st.nextToken());

            distances[i] = a * a + b * b;
        }

        Arrays.sort(distances);

        int max = 1;

        int l = 0, r = 0;

        while (r < n) {
            if (inRange(distances[r], distances[l], k)) max = Math.max(max, ++r - l);
            else l++;
        }

        System.out.println((double) max / n * 100);
    }

    static boolean inRange(long a, long b, long k) {

        long d = a + b - k * k;

        if (d <= 0) return true;

        return d * d <= 4 * a * b;
    }
}