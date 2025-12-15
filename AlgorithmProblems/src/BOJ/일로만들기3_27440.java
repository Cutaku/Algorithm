package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class 일로만들기3_27440 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        Set<Long> v = new HashSet<>();

        Queue<Long> q1 = new ArrayDeque<>();
        Queue<Long> q2 = new ArrayDeque<>();

        q1.add(n);
        v.add(n);

        int ans = 0;

        while (!q1.isEmpty()) {
            long p = q1.poll();

            if (p == 1) {
                System.out.println(ans);
                return;
            }

            if (p % 2 == 0 && v.add(p / 2)) {
                q2.add(p / 2);
            }

            if (p % 3 == 0 && v.add(p / 3)) {
                q2.add(p / 3);
            }

            if (v.add(p - 1)) {
                q2.add(p - 1);
            }


            if (q1.isEmpty()) {
                Queue<Long> tmp = q1;
                q1 = q2;
                q2 = tmp;

                ans++;
            }
        }
    }
}