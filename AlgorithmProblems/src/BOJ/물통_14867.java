package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 물통_14867 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());        long c = Long.parseLong(st.nextToken());
        long d = Long.parseLong(st.nextToken());
        long m = 100001L;

        long goal = m * c + d;
        Set<Long> v = new HashSet<>();

        Queue<Long> q1 = new ArrayDeque<>();
        Queue<Long> q2 = new ArrayDeque<>();

        q1.add(0L);
        v.add(0L);

        int cnt = 0;

        while (!q1.isEmpty()) {
            long p = q1.poll();

            if (p == goal) {
                System.out.println(cnt);
                return;
            }

            long x = p / m, y = p % m;

            if (v.add(m * x)) {
                q2.add(m * x);
            }

            if (v.add(y)) {
                q2.add(y);
            }

            if (v.add(m * a + y)) {
                q2.add(m * a + y);
            }

            if (v.add(m * x + b)) {
                q2.add(m * x + b);
            }

            long d1 = Math.min(x + y, a);

            if (v.add(m * d1 + (x + y - d1))) {
                q2.add(m * d1 + (x + y - d1));
            }

            long d2 = Math.min(x + y, b);

            if (v.add(m * (x + y - d2) + d2)) {
                q2.add(m * (x + y - d2) + d2);
            }

            if (q1.isEmpty()) {
                Queue<Long> tmp = q1;
                q1 = q2;
                q2 = tmp;

                cnt++;
            }
        }

        System.out.println(-1);
    }
}