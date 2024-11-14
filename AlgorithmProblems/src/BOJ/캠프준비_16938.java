package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 캠프준비_16938 {
    static int n, l, r, x;
    static int[] problems;
    static int ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        problems = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) problems[i] = Integer.parseInt(st.nextToken());

        ans = 0;

        dfs(0, 0, 1000001, 0, 0);

        System.out.println(ans);
    }

    static void dfs(int d, int c, int min, int max, int sum) {

        if (sum > r) return;

        if (d == n) {
            if (c >= 2 && max - min >= x && sum >= l) ans++;


            return;
        }

        dfs(d + 1, c + 1, Math.min(min, problems[d]), Math.max(max, problems[d]), sum + problems[d]);
        dfs(d + 1, c, min, max, sum);
    }
}