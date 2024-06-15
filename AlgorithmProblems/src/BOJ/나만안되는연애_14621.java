package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 나만안되는연애_14621 {
    static int[] root;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        boolean[] man = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)  man[i] = st.nextToken().equals("M");

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int[] edge = {Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1,
                    Integer.parseInt(st.nextToken())};

            if (man[edge[0]] ^ man[edge[1]]) pq.add(edge);
        }

        root = new int[n];
        for (int i = 1; i < n; i++) root[i] = i;

        int count = 1;
        int ans = 0;

        while (!pq.isEmpty() && count < n) {
            int[] now = pq.poll();

            int a = find(now[0]);
            int b = find(now[1]);

            if (a == b) continue;

            ans += now[2];

            count++;

            root[Math.max(a, b)] = Math.min(a, b);
        }

        System.out.println(count == n ? ans : -1);
    }

    static int find(int a) {

        if (a == root[a]) return a;
        return root[a] = find(root[a]);
    }
}