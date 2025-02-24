package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 제기차기_23830 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] count = new int[100001];
        long sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int score = Integer.parseInt(st.nextToken());

            sum += score;
            count[score]++;
        }

        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        long s = Long.parseLong(st.nextToken());

        for (int i = 1; i < 100001; i++) count[i] += count[i - 1];

        if (sum + n * q < s) {
            System.out.println(-1);
            return;
        }

        int a = 0, b = 100001;

        while (b - a > 1) {
            int m = (a + b) / 2;

            int under = count[m - 1];
            int over = m + r < 100001 ? n - count[m + r] : 0;

            long c = sum + under * q - over * p;

            if (c < s) a = m;
            else b = m;
        }

        System.out.println(b);
    }
}