package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 난로_15553 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        int last = Integer.parseInt(br.readLine());

        int[] d = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            int t = Integer.parseInt(br.readLine());

            d[i] = t - last - 1;
            last = t;
        }

        Arrays.sort(d);

        int ans = n;
        for (int i = 0; i < n - k; i++) ans += d[i];

        System.out.println(ans);
    }
}