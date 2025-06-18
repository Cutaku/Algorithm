package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 시간낭비_30464 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] cnt = new int[n];

        Arrays.fill(cnt, -1);
        cnt[0] = 0;

        int[] jump = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) jump[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n - 1; i++) {
            if (cnt[i] < 0) continue;

            if (i + jump[i] < n) cnt[i + jump[i]] = Math.max(cnt[i + jump[i]], cnt[i] + 1);
        }

        for (int i = n - 2; i > 0; i--) {
            if (cnt[i] < 0) continue;

            if (i - jump[i] >= 0) cnt[i - jump[i]] = Math.max(cnt[i - jump[i]], cnt[i] + 1);
        }

        for (int i = 0; i < n - 1; i++) {
            if (cnt[i] < 0) continue;

            if (i + jump[i] < n) cnt[i + jump[i]] = Math.max(cnt[i + jump[i]], cnt[i] + 1);
        }

        System.out.println(cnt[n - 1]);
    }
}