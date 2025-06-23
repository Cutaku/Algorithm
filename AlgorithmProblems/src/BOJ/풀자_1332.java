package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 풀자_1332 {
    static int n, v;
    static int[] points;
    static int ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        points = new int[n];

        int max = 0;
        int min = 1000;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            points[i] = Integer.parseInt(st.nextToken());

            max = Math.max(max, points[i]);
            min = Math.min(min, points[i]);
        }

        if (max - min < v) {
            System.out.println(n);
            return;
        }

        ans = n;

        dfs(1, points[0], points[0], 1);
        dfs(2, points[0], points[0], 1);

        System.out.println(ans);
    }

    static void dfs(int d, int min, int max, int cnt) {

        if (cnt == ans) return;

        if (max - min >= v) {
            ans = Math.min(ans, cnt);
            return;
        }

        if (d >= n) return;

        dfs(d + 2, Math.min(min, points[d]), Math.max(max, points[d]), cnt + 1);
        dfs(d + 1, Math.min(min, points[d]), Math.max(max, points[d]), cnt + 1);
    }
}