package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 전국시대_15809 {
    static int[] root;
    static int[] army;
    static boolean[] removed;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        int ans = n - m;

        root = new int[n];
        army = new int[n];

        removed = new boolean[n];

        for (int i = 0; i < n; i++) {
            root[i] = i;
            army[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            char o = st.nextToken().charAt(0);

            int a = find(Integer.parseInt(st.nextToken()) - 1);
            int b = find(Integer.parseInt(st.nextToken()) - 1);

            if (o == '1') {
                if (a > b) {
                    int t = a;
                    a = b;
                    b = t;
                }

                army[a] += army[b];
            } else {
                if (army[a] == army[b]) {
                    ans--;

                    removed[a] = true;
                    removed[b] = true;

                    continue;
                }

                if (army[b] > army[a]) {
                    int t = a;
                    a = b;
                    b = t;
                }

                army[a] -= army[b];
            }

            root[b] = a;
            removed[b] = true;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            if (!removed[i]) {
                pq.add(army[i]);
            }
        }

        sb.append(ans).append("\n");

        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append(" ");
        }

        System.out.println(sb);
    }

    static int find(int a) {

        if (a == root[a]) return a;
        return root[a] = find(root[a]);
    }
}