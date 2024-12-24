package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 누가크리스마스소리를내었는가_14946 {
    static int v, q, k;
    static List<Integer>[] adj;
    static int[][] costs;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        adj = new List[v];
        for (int i = 0; i < v; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < v - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1, b = Integer.parseInt(st.nextToken()) - 1;

            adj[a].add(b);
            adj[b].add(a);
        }

        costs = new int[v][3];

        for (int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine());

            costs[i][0] = Integer.parseInt(st.nextToken());
            costs[i][1] = Integer.parseInt(st.nextToken());
            costs[i][2] = Integer.parseInt(st.nextToken());
        }

        visit =  new boolean[v];

        int[][] res = count(0);

        System.out.println((res[0][0] + res[1][0] + res[2][0]) % q);
    }

    static int[][] count(int i) {

        visit[i] = true;

        int[][] res = new int[3][k];

        res[0][costs[i][0] % k]++;
        res[1][costs[i][1] % k]++;
        res[2][costs[i][2] % k]++;

        for (int child : adj[i]) {
            if (visit[child]) continue;

            int[][] cRes = count(child);
            int[][] tmp = new int[3][k];

            for (int j = 0; j < k; j++) {
                for (int l = 0; l < k; l++) {
                    tmp[0][(j + l) % k] += res[0][j] * (cRes[0][l] + cRes[1][l]);
                    tmp[0][(j + l) % k] %= q;

                    tmp[1][(j + l) % k] += res[1][j] * (cRes[0][l] + cRes[2][l]);
                    tmp[1][(j + l) % k] %= q;

                    tmp[2][(j + l) % k] += res[2][j] * cRes[1][l];
                    tmp[2][(j + l) % k] %= q;
                }
            }

            res = tmp;
        }

        return res;
    }
}