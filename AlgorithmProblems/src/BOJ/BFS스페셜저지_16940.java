package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BFS스페셜저지_16940 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken()) - 1;
            int v2 = Integer.parseInt(st.nextToken()) - 1;

            adj[v1].add(v2);
            adj[v2].add(v1);
        }

        int[] d = new int[n];
        d[0] = 1;

        int last = 1;
        int t = 2;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(st.nextToken()) - 1;

            if (d[now] < last) {
                System.out.println(0);
                return;
            }

            last = d[now];

            for (int next : adj[now]) {
                if (d[next] == 0) {
                    d[next] = t;
                }
            }

            t++;
        }

        System.out.println(1);
    }
}