package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 짚신벌레_2560 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] unable = new int[n + 1];
        int[] able = new int[n + 1];

        unable[0]++;

        if (a <= n) {
            unable[a]--;
            able[a]++;
        }

        if (b <= n) {
            able[b]--;
            unable[b]++;
        }

        if (d <= n) {
            unable[d]--;
        }

        for (int i = 1; i <= n; i++) {
            unable[i] = (unable[i] + unable[i - 1]) % 1000;
            able[i] = (able[i] + able[i - 1]) % 1000;

            unable[i] = (unable[i] + able[i]) % 1000;

            if (i + a <= n) {
                unable[i + a] = (unable[i + a] - able[i] + 1000) % 1000;
                able[i + a] = (able[i + a] + able[i]) % 1000;
            }

            if (i + b <= n) {
                able[i + b] = (able[i + b] - able[i] + 1000) % 1000;
                unable[i + b] = (unable[i + b] + able[i]) % 1000;
            }

            if (i + d <= n) {
                unable[i + d] = (unable[i + d] - able[i] + 1000) % 1000;
            }
        }

        System.out.println((unable[n] + able[n]) % 1000);
    }
}