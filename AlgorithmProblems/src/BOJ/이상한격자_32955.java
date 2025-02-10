package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 이상한격자_32955 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        long d = Long.parseLong(st.nextToken());

        int[] x = new int[n];
        int[] y = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(x);
        Arrays.sort(y);

        int nx = 0;
        int ny = 0;

        for (int i = 1; i < n; i++) {
            if (x[i - 1] < x[i] && b * i <= a * (n - i)) {
                nx = i;
            }

            if (y[i - 1] < y[i] && d * i <= c * (n - i)) {
                ny = i;
            }
        }

        long ans = 0;

        for (int i = 0; i < n; i++) {
            ans += Math.abs(x[nx] - x[i]) * (i < nx ? b : a);
            ans += Math.abs(y[ny] - y[i]) * (i < ny ? d : c);
        }

        System.out.println(ans);
    }
}