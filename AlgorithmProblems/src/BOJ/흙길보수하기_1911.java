package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 흙길보수하기_1911 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), l = Integer.parseInt(st.nextToken());

        int[][] puddles = new int[n][];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            puddles[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        Arrays.sort(puddles, Comparator.comparingInt(a -> a[0]));

        int ans = 0;
        int last = 0;

        for (int i = 0; i < n; i++) {
            int s = puddles[i][0], e = puddles[i][1];

            if (last > s) s = last;

            int m = (e - s + l - 1) / l;

            ans += m;
            last = s + l * m;
        }

        System.out.println(ans);
    }
}