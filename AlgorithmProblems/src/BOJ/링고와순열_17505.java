package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 링고와순열_17505 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        boolean[] used = new boolean[n];
        int idx = n - 1;

        StringBuilder sb = new StringBuilder();

        while (k > 0) {
            if (k >= idx) {
                sb.append(idx + 1).append(" ");
                used[idx] = true;

                k -= idx;
            }

            idx--;
        }

        for (int i = 0; i < n; i++) {
            if (!used[i]) sb.append(i + 1).append(" ");
        }

        System.out.println(sb);
    }
}