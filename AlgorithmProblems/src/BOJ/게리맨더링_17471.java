package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 게리맨더링_17471 {
    static int n;
    static Map<Integer, Integer> populations;
    static List<Integer>[] adj;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        populations = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            populations.put(1 << i, Integer.parseInt(st.nextToken()));
        }

        adj = new List[1 << n];
        for (int i = 0; i < n; i++) adj[1 << i] = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());

            for (int j = 0; j < k; j++) adj[1 << i].add(1 << (Integer.parseInt(st.nextToken()) - 1));
        }

        int m = (1 << n) / 2;

        int min = 1000;

        for (int i = 1; i < m; i++) {
            min = Math.min(min, findDif(i));
        }

        if (min < 1000) System.out.println(min);
        else System.out.println(-1);
    }

    static int findDif(int m) {

        int left = (1 << n) - 1 - m;


        int a = isConnected(m);
        int b = isConnected(left);

        if (Math.abs(a - b) == 2) {
            System.out.println(m);
            System.out.println(left);
        }

        if (a > -1 && b > -1) return Math.abs(a - b);
        else return 1000;
    }

    static int isConnected(int m) {

        Queue<Integer> q = new ArrayDeque<>();
        q.add(m & -m);

        int sum = populations.get(m & -m);
        m -= m & -m;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : adj[now]) {
                if ((m & next) > 0) {
                    m -= next;
                    q.add(next);
                    sum += populations.get(next);
                }
            }
        }

        if (m > 0) return -1;
        else return sum;
    }
}