package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 균형_22968 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] cnt = new int[44];
        cnt[1] = 1;

        for (int i = 2; i < 44; i++) {
            cnt[i] = cnt[i - 1] + cnt[i - 2] + 1;
        }

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int v = Integer.parseInt(br.readLine());

            int s = 0, e = 43;

            while (e - s > 1) {
                int m = (s + e) >> 1;

                if (cnt[m] <= v) s = m;
                else e = m;
            }

            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }
}