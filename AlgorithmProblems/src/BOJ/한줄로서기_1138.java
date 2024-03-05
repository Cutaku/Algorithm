package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 한줄로서기_1138 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] ans = new int[n];

        for (int i = 1; i <= n; i++) {
            int p = Integer.parseInt(st.nextToken());

            for (int j = 0; j < n; j++) {
                if (ans[j] > 0) continue;

                if (p-- == 0) {
                    ans[j] = i;
                    break;
                }
            }
        }

        for (int a : ans) {
            sb.append(a).append(' ');
        }

        System.out.println(sb);
    }
}