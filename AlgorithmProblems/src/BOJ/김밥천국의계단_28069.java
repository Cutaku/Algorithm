package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 김밥천국의계단_28069 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();

        boolean[] v = new boolean[n + 1];

        q1.add(0);
        v[0] = true;

        while (!q1.isEmpty() && k > 0) {
            int now = q1.poll();

            if (now == n) break;

            if (now < n && !v[now + 1]) {
                q2.add(now + 1);
                v[now + 1] = true;
            }

            int m = now + now / 2;

            if (m <= n && !v[m]) {
                q2.add(m);
                v[m] = true;
            }

            if (q1.isEmpty()) {
                Queue<Integer> tmp = q1;
                q1 = q2;
                q2 = tmp;

                k--;
            }
        }

        System.out.println(v[n] ? "minigimbob" : "water");
    }
}