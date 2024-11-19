package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문제없는문제_5175 {
    static int m, n;
    static int[] problems;
    static int min, ans;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int k = Integer.parseInt(br.readLine());

        for (int i = 1; i <= k; i++) {
            sb.append("Data Set ").append(i).append(": ");

            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            problems = new int[n];

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());

                while (st.hasMoreTokens()) {
                    problems[j] |= 1 << (Integer.parseInt(st.nextToken()) - 1);
                }
            }

            min = 21;
            ans = 0;

            dfs(0, 0, 0, 0);

            for (int j = 0; j < n; j++) {
                if ((ans & (1 << j)) > 0) {
                    sb.append((char) ('A' + j)).append(" ");
                }
            }

            sb.append("\n\n");
        }

        System.out.println(sb);
    }

    static void dfs(int d, int c, int sum, int use) {

        if (c >= min) return;

        if (sum == (1 << m) - 1) {
            min = c;
            ans = use;

            return;
        }

        if (d == n) return;

        dfs(d + 1, c + 1, sum | problems[d], use | (1 << d));
        dfs(d + 1, c, sum, use);
    }
}