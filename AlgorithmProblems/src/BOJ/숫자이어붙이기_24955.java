package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 숫자이어붙이기_24955 {
    static int[] arr, length;
    static long[] dec;
    static int d = 1000000007;
    static List<Integer>[] adj;
    static StringBuilder sb;
    static boolean[] v;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), q = Integer.parseInt(st.nextToken());

        arr = new int[n];
        length = new int[n];
        dec = new long[11];

        dec[0] = 1L;
        for (int i = 1; i < 11; i++) dec[i] = dec[i - 1] * 10 % d;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            String input = st.nextToken();

            arr[i] = Integer.parseInt(input);
            length[i] = input.length();
        }

        adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1, b = Integer.parseInt(st.nextToken()) - 1;

            adj[a].add(b);
            adj[b].add(a);
        }

        sb = new StringBuilder();

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1, y = Integer.parseInt(st.nextToken()) - 1;

            v = new boolean[n];
            v[x] = true;

            dfs(x, y, arr[x]);
        }

        System.out.println(sb);
    }

    static boolean dfs(int i, int y,long sum) {

        if (i == y) {
            sb.append(sum).append("\n");

            return true;
        }

        for (int next : adj[i]) {
            if (v[next]) continue;
            v[next] = true;

            if (dfs(next, y, (sum * dec[length[next]] + arr[next]) % d)) return true;
        }

        return false;
    }
}