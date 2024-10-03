package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PERICA_11876 {
    static final int d = 1000000007;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        long f = 1;
        for (int i = 1; i < k; i++) f = f * i % d;

        f = power(f, d - 2) % d;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) pq.add(Integer.parseInt(st.nextToken()));

        long ans = 0;

        for (int i = 0; i < k - 1; i++) pq.poll();

        for (int i = k; i <= n; i++) {
            long m = f;

            for (int j = i - k + 1; j < i; j++) {
                m = m * j % d;
            }

            ans = (ans + m * pq.poll() % d) % d;
        }

        System.out.println(ans);
    }

    static long power(long a, int p) {

        long res = 1;

        while (p > 0)  {
            if (p % 2 == 0) {
                a = (a * a) % d;
                p >>= 1;
            } else {
                res = (res * a) % d;
                p--;
            }
        }

        return res;
    }
}