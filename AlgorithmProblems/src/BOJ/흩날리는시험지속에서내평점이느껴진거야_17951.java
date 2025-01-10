package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 흩날리는시험지속에서내평점이느껴진거야_17951 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        int[] scores = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) scores[i] = scores[i - 1] + Integer.parseInt(st.nextToken());

        int s = 0, e = scores[n] + 1;

        while (e - s > 1) {
            int m = (s + e) / 2;
            int cnt = 0;
            int idx = 0;

            for (int i = 1; i <= n; i++) {
                if (scores[i] - scores[idx] >= m) {
                    cnt++;
                    idx = i;
                }
            }

            if (cnt >= k) s = m;
            else e = m;
        }

        System.out.println(s);
    }
}