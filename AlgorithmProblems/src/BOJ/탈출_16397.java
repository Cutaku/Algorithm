package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 탈출_16397 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());

        boolean[] v = new boolean[100000];

        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();

        q1.add(n);
        v[n] = true;

        int c = 0;

        while (!q1.isEmpty()) {
            int now = q1.poll();

            if (now == g) {
                System.out.println(c);
                return;
            }

            if (now < 99999 && !v[now + 1]) {
                v[now + 1] = true;
                q2.add(now + 1);
            }

            int m = 2 * now;

            if (m < 100000 && now > 0) {
                int d = 1;

                while (10 * d <= m) d *= 10;

                m -= d;

                if (!v[m]) {
                    v[m] = true;
                    q2.add(m);
                }
            }

            if (q1.isEmpty()) {
                Queue<Integer> tmp = q1;
                q1 = q2;
                q2 = tmp;

                if (c++ >= t) {
                    System.out.println("ANG");
                    return;
                }
            }
        }

        System.out.println("ANG");
    }
}