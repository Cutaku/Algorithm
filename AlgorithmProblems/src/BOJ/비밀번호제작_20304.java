package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 비밀번호제작_20304 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();

        boolean[] v = new boolean[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int p = Integer.parseInt(st.nextToken());

            q1.add(p);
            v[p] = true;
        }

        int t = 0;

        while (!q1.isEmpty()) {
            int now = q1.poll();

            for (int i = 0; i < 20; i++) {
                int next = now ^ (1 << i);

                if (next > n || v[next]) continue;

                v[next] = true;

                q2.add(next);
            }

            if (q1.isEmpty() && !q2.isEmpty()) {
                Queue<Integer> tmp = q1;
                q1 = q2;
                q2 = tmp;

                t++;
            }
        }

        System.out.println(t);
    }
}