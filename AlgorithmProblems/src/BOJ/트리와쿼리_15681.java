package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 트리와쿼리_15681 {
    static int n, r, q;
    static List<Integer>[] adj;
    static int[] subtrees;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken()) - 1;
        q = Integer.parseInt(st.nextToken());

        adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken()) - 1;
            int v2 = Integer.parseInt(st.nextToken()) - 1;

            adj[v1].add(v2);
            adj[v2].add(v1);
        }

        subtrees = new int[n];
        Arrays.fill(subtrees, 1);

        countSubtree(r, -1);

        for (int i = 0; i < q; i++) {
            sb.append(subtrees[Integer.parseInt(br.readLine()) - 1]).append("\n");
        }

        System.out.println(sb);
    }

    static int countSubtree(int n, int parent) {

        for (int child : adj[n]) {
            if (child == parent) continue;

            subtrees[n] += countSubtree(child, n);
        }

        return subtrees[n];
    }
}