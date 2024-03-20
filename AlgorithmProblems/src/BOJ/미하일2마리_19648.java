package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 미하일2마리_19648 {
    static long[][] mat;
    static long[][] res;
    static int d = 1000000007;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        init();

        int n = Integer.parseInt(br.readLine());

        res = new long[32][32];
        for (int i = 0; i < 32; i++) res[i][i] = 1;

        while (n > 0) {
            if (n % 2 == 0) {
                mat = matMul(mat, mat);
                n >>= 1;
            } else {
                res = matMul(res, mat);
                n--;
            }
        }

        long ans = 0;

        for (int i = 0; i < 32; i++) ans += res[0][i];

        System.out.println(ans % d);
    }

    static long[][] matMul(long[][] A, long[][] B) {

        long[][] res = new long[32][32];

        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < 32; j++) {
                for (int k = 0; k < 32; k++) {
                    res[i][j] += A[i][k] * B[k][j];
                    res[i][j] %= d;
                }
            }
        }

        return res;
    }

    static void init() {

        List<Integer>[] adj = new List[14];
        for (int i = 0; i < 14; i++) adj[i] = new ArrayList<>();

        adj[0].add(1);
        adj[1].addAll(Arrays.asList(0, 2));
        adj[2].add(4);
        adj[3].addAll(Arrays.asList(0, 1, 4));
        adj[4].addAll(Arrays.asList(6, 7));
        adj[5].add(3);
        adj[6].addAll(Arrays.asList(3, 7, 8, 9, 10));
        adj[7].add(10);
        adj[8].add(5);
        adj[9].addAll(Arrays.asList(8, 12));
        adj[10].addAll(Arrays.asList(9, 13));
        adj[11].add(8);
        adj[12].addAll(Arrays.asList(8, 11));
        adj[13].add(12);

        int[][] min = new int[14][14];

        for (int i = 0; i < 14; i++) {
            Arrays.fill(min[i], 15);

            for (int to : adj[i]) {
                min[i][to] = 1;
            }

            min[i][i] = 0;
        }


        for (int k = 0; k < 14; k++) {
            for (int i = 0; i < 14; i++) {
                for (int j = 0; j < 14; j++) {
                    min[i][j] = Math.min(min[i][j], min[i][k] + min[k][j]);
                }
            }
        }

        Map<Integer, Integer> map = new HashMap<>();

        Queue<Integer> q = new ArrayDeque<>();
        q.add(309);
        map.put(309, 0);

        mat = new long[32][32];

        while (!q.isEmpty()) {
            int now = q.poll();
            int a = now / 100;
            int b = now % 100;

            for (int i : adj[a]) {
                for (int j : adj[b]) {
                    if (min[i][j] < 3 || min[j][i] < 3) continue;

                    int next = i * 100 + j;

                    if (!map.containsKey(next)) {
                        map.put(next, map.size());
                        q.add(next);
                    }

                    mat[map.get(now)][map.get(next)] = 1;
                }
            }
        }
    }
}