package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 사연산_14395 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken()), t = Integer.parseInt(st.nextToken());

        if (s == t) {
            System.out.println(0);
            return;
        }

        int limit = Math.min(t, (int) Math.sqrt(1000000001));

        Set<Integer> set = new HashSet<>();

        Queue<Ans> q = new ArrayDeque<>();
        q.add(new Ans(s));
        set.add(s);

        while (!q.isEmpty()) {
            Ans now = q.poll();
            int num = now.num;

            if (num == t) {
                System.out.println(now.history);
                return;
            }

            if (num < limit && set.add(num * num)) {
                q.add(new Ans(num * num, now.history + '*'));
            }

            if ((num << 1) <= t && set.add(num << 1)) {
                q.add(new Ans(2 * num, now.history + '+'));
            }

            if (set.add(1)) {
                q.add(new Ans(1, now.history + '/'));
            }
        }

        System.out.println(-1);
    }

    static class Ans {
        int num;
        String history = "";

        public Ans(int num) {
            this.num = num;
        }

        public Ans(int num, String history) {
            this.num = num;
            this.history = history;
        }
    }
}