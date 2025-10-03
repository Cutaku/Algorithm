package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class 나무막대_7344 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] blocks = new int[n][2];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) blocks[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            Arrays.sort(blocks, (a, b) -> {
                if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
                else return Integer.compare(a[0], b[0]);
            });

            Queue<Integer> q = new ArrayDeque<>();
            for (int i = 0; i < n; i++) q.add(blocks[i][1]);

            int ans = 0;

            while (!q.isEmpty()) {
                ans++;

                int s = q.size();
                int l = 0;

                for (int i = 0; i < s; i++) {
                    int p = q.poll();

                    if (l > p) q.add(p);
                    else l = p;
                }
            }

            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }
}