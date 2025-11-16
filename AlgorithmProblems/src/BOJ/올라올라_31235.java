package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 올라올라_31235 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int ans = 1;

        int max = 0;
        int idx = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());

            if (max <= a) {
                max = a;
                ans = Math.max(ans, i - idx);
                idx = i;
            }
        }

        ans = Math.max(ans, n - idx);

        System.out.println(ans);
    }
}