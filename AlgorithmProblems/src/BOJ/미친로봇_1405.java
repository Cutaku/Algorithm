package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 미친로봇_1405 {
    static int n;
    static double[] probabilities;
    static double sum;
    static boolean[] visited = new boolean[10000];
    static int[][] D = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        probabilities = new double[4];

        for (int i = 0; i < 4; i++) {
            probabilities[i] = Double.parseDouble(st.nextToken()) / 100;
        }

        sum = 0;

        visited[2020] = true;
        dfs(20, 20, 0, 1);

        System.out.println(sum);
    }

    static void dfs(int x, int y, int d, double p) {

        if (d == n) {
            sum += p;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + D[i][0];
            int ny = y + D[i][1];
            int v = 100 * nx + ny;

            if (visited[v]) continue;

            visited[v] = true;
            dfs(nx, ny, d + 1, p * probabilities[i]);
            visited[v] = false;
        }
    }
}