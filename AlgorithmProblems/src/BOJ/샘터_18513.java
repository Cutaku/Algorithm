package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 샘터_18513 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        int[] fountains = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) fountains[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(fountains);

        int[] cnt = new int[50001];
        cnt[1] = 2;

        for (int i = 1; i < n; i++) {
            int d = fountains[i] - fountains[i - 1] - 1;
            int h = d / 2;
            int l = d - h;

            if (h > 0) {
                cnt[1]++;

                if (h < 50000) cnt[h + 1]--;
            }

            if (l > 0) {
                cnt[1]++;

                if (l < 50000) cnt[l + 1]--;
            }
        }

        long ans = 0;
        int idx = 1;

        while (k > 0) {
            cnt[idx] += cnt[idx - 1];

            ans += (long) idx * Math.min(cnt[idx], k);
            k -= cnt[idx++];
        }

        System.out.println(ans);
    }
}