package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class 이진수게임_18112 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int s = 0;

        for (int i = 0; i < input.length(); i++) {
            s <<= 1;
            s |= input.charAt(i) - '0';
        }

        input = br.readLine();
        int t = 0;

        for (int i = 0; i < input.length(); i++) {
            t <<= 1;
            t |= input.charAt(i) - '0';
        }

        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();

        boolean[] v = new boolean[1024];

        q1.add(s);
        v[s] = true;

        int c = 0;

        while (!q1.isEmpty()) {
            int now = q1.poll();

            if (now == t) {
                System.out.println(c);
                return;
            }

            int m = Integer.highestOneBit(now);

            for (int i = 0; i < 10; i++) {
                if (1 << i >= m) break;

                int next = now ^ (1 << i);

                if (v[next]) continue;

                v[next] = true;

                q2.add(next);
            }

            if (now < 1023 && !v[now + 1]) {
                v[now + 1] = true;
                q2.add(now + 1);
            }

            if (now > 0 && !v[now - 1]) {
                v[now - 1] = true;
                q2.add(now - 1);
            }

            if (q1.isEmpty()) {
                Queue<Integer> tmp = q1;
                q1 = q2;
                q2 = tmp;

                c++;
            }
        }
    }
}