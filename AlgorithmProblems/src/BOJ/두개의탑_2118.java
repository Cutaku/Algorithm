package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 두개의탑_2118 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] sum = new int[n + 1];

        for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + Integer.parseInt(br.readLine());

        int l = sum[n];
        int h = l / 2;

        int s = 0, e = 1;
        int max = 0;

        while (e <= n) {
            int d = sum[e] - sum[s];
            max = Math.max(max, Math.min(d, l - d));

            if (d == h || d == l - h) break;
            else if (d < h) e++;
            else s++;
        }

        System.out.println(max);
    }
}