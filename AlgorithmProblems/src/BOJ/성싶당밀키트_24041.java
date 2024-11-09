package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 성싶당밀키트_24041 {
    static int n, g, k;
    static int max = 2000000000;
    static List<int[]> list1, list2;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        list1 = new ArrayList<>();
        list2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int[] ingredient = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            if (st.nextToken().charAt(0) == '0') list1.add(ingredient);
            else list2.add(ingredient);
        }

        if (countBacteria(max) <= g) {
            System.out.println(max);
            return;
        }

        long s = 0, e = max;

        while (e - s > 1) {
            long m = (s + e) / 2;

            if (countBacteria(m) > g) e = m;
            else s = m;
        }

        System.out.println(s);
    }

    static long countBacteria(long d) {

        long res = 0;

        for (int[] ingredient : list1) {
            res += (long) ingredient[0] * Math.max(1, d - ingredient[1]);

            if (res > g) return g + 1;
        }

        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int i = 0; i < list2.size(); i++) {
            int[] ingredient = list2.get(i);

            pq.add((long) ingredient[0] * Math.max(1, d - ingredient[1]));

            if (i >= k) res += pq.poll();
            if (res > g) return g + 1;
        }

        return res;
    }
}