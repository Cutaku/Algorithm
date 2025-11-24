package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 택배상하차는힘들어_33681 {
    static int n;
    static long[] parcel;
    static List<Integer>[] adj;
    static long res;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        parcel = new long[n];
        for (int i = 0; i < n; i++) parcel[i] = Integer.parseInt(st.nextToken());

        adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;

            adj[u].add(v);
            adj[v].add(u);
        }

        res = 0;
        for (int i : adj[0]) {
            count(i, 0);
            res += parcel[i];
        }

        System.out.println(res);
    }

    static void count(int i, int b) {

        res += parcel[i];
        long max = 0;

        for (int j : adj[i]) {
            if (j == b) continue;

            count(j, i);

            res += 2L * parcel[j];
            max = Math.max(max, parcel[j]);

            parcel[i] += parcel[j];
        }

        res -= 2L * max;
    }
}