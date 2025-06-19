package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 암벽등반_2412 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), T = Integer.parseInt(st.nextToken());

        Set<Long> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());

            if (x > 2 * n) continue;

            set.add(200001L * x + y);
        }

        Queue<Long> q1 = new ArrayDeque<>();
        Queue<Long> q2 = new ArrayDeque<>();

        q1.add(0L);

        int cnt = 0;

        while (!q1.isEmpty()) {
            long l = q1.poll();
            int x = (int) l / 200001;
            int y = (int) l % 200001;

            if (y == T) {
                System.out.println(cnt);
                return;
            }

            for (int i = Math.max(0, x - 2); i <= x + 2; i++) {
                for (int j = Math.max(0, y - 2); j <= Math.min(T, y + 2); j++) {
                    long m = 200001L * i + j;

                    if (!set.contains(m)) continue;

                    set.remove(m);
                    q2.add(m);
                }
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