package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class CowDanceShow_14452 {
    static int n, t;
    static int[] cows;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        cows = new int[n];
        for (int i = 0; i < n; i++) cows[i] = Integer.parseInt(br.readLine());

        int s = 0, e = n;

        while (e - s > 1) {
            int m = (s + e) >> 1;

            if (check(m)) e = m;
            else s = m;
        }

        System.out.println(e);
    }

    static boolean check(int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < k; i++) pq.add(cows[i]);
        for (int i = k; i < n; i++) pq.add(pq.poll() + cows[i]);

        while (pq.size() > 1) pq.poll();

        return pq.poll() <= t;
    }
}