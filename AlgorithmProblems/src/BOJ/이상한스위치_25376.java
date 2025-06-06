package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 이상한스위치_25376 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean[] v = new boolean[1 << n];

        int start = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) start |= (1 - Integer.parseInt(st.nextToken())) << i;

        int[] reverse = new int[(1 << (n - 1)) + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int c = Integer.parseInt(st.nextToken());

            reverse[1 << i] |= 1 << i;

            for (int j = 0; j < c; j++) {
                reverse[1 << i] |= 1 << (Integer.parseInt(st.nextToken()) - 1);
            }
        }

        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();

        q1.add(start);
        v[start] = true;

        int cnt = 0;

        while (!q1.isEmpty()) {
            int now = q1.poll();

            if (now == 0) {
                System.out.println(cnt);
                return;
            }

            int r = now;

            while (r > 0) {
                int b = r & -r;
                r -= b;

                int next = now ^ reverse[b];

                if (v[next]) continue;

                q2.add(next);
                v[next] = true;
            }

            if (q1.isEmpty()) {
                Queue<Integer> tmp = q1;
                q1 = q2;
                q2 = tmp;

                cnt++;
            }
        }

        System.out.println(-1);
    }
}