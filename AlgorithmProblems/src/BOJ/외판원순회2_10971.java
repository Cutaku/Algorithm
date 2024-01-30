package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 외판원순회2_10971 {
    static int n;
    static int[][] W;
    static int min;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        W = new int[n][];
        for (int i = 0; i < n; i++) {
            W[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        min = Integer.MAX_VALUE;

        visited = new boolean[n];

        dfs(0, 0, 0);

        System.out.println(min);
    }

    static void dfs(int s, int sum, int d) {
        if (d == n - 1) {
            if (W[s][0] > 0) min = Math.min(min, sum + W[s][0]);
            return;
        }

        for (int i = 1; i < n; i++) {
            if (visited[i] || W[s][i] == 0) continue;

            visited[i] = true;

            dfs(i, sum + W[s][i], d + 1);

            visited[i] = false;
        }
    }
}