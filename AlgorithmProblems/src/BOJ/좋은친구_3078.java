package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 좋은친구_3078 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        String[] names = new String[n];
        for (int i = 0; i < n; i++) names[i] = br.readLine();

        int[] cnt = new int[21];
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int l = names[i].length();

            ans += cnt[l]++;

            if (k <= i) {
                cnt[names[i - k].length()]--;
            }
        }

        System.out.println(ans);
    }
}