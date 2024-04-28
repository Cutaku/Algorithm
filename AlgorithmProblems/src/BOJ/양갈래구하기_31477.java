package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 양갈래구하기_31477 {
    static List<int[]>[] adj;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken());

            adj[a].add(new int[]{b, v});
            adj[b].add(new int[]{a, v});
        }

        System.out.println(findMin(0, 0));
    }

    static int findMin(int v, int b) {

        int sum = 0;
        int count = 0;

        for (int[] child : adj[v]) {
            if (child[0] == b) continue;

            count++;
            sum += Math.min(findMin(child[0], v), child[1]);
        }

        if (count == 0) return 100000000;
        else return sum;
    }
}