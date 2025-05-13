package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 행복유치원_13164 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        int[] d = new int[n - 1];

        st = new StringTokenizer(br.readLine());
        int last = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n - 1; i++) {
            int h = Integer.parseInt(st.nextToken());

            d[i] = h - last;
            last = h;
        }

        Arrays.sort(d);

        int ans = 0;

        for (int i = 0; i < n - k; i++) {
            ans += d[i];
        }

        System.out.println(ans);
    }
}