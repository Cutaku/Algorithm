package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 코딩은예쁘게_2879 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int ans = 0;

        int last = 0;

        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(st1.nextToken()) - Integer.parseInt(st2.nextToken());

            if (now * last < 0) {
                ans += Math.abs(now);
            } else {
                ans += Math.max(0, Math.abs(now) - Math.abs(last));
            }

            last = now;
        }

        System.out.println(ans);
    }
}