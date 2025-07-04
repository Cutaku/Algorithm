package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 가로등_32069 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long l = Long.parseLong(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Set<Long> v = new HashSet<>();

        Queue<Long> q1 = new ArrayDeque<>();
        Queue<Long> q2 = new ArrayDeque<>();

        int cnt = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            long a = Long.parseLong(st.nextToken());

            q1.add(a);
            v.add(a);
        }

        StringBuilder sb = new StringBuilder();

        while (true) {
            int c = Math.min(k, q1.size());
            k -= c;

            for (int i = 0; i < c; i++) sb.append(cnt).append("\n");

            if (k == 0) break;

            while (!q1.isEmpty()) {
                long a = q1.poll();

                if (a < l && v.add(a + 1)) q2.add(a + 1);
                if (a > 0 && v.add(a - 1)) q2.add(a - 1);
            }

            Queue<Long> tmp = q1;
            q1 = q2;
            q2 = tmp;

            cnt++;
        }

        System.out.println(sb);
    }
}