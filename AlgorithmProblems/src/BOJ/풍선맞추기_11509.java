package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 풍선맞추기_11509 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] cnt = new int[1000001];
        int ans = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int h = Integer.parseInt(st.nextToken());

            if (cnt[h] > 0) cnt[h]--;
            else ans ++;

            cnt[h - 1]++;
        }

        System.out.println(ans);
    }
}