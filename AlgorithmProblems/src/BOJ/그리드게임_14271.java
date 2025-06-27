package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 그리드게임_14271 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        Set<Integer> v = new HashSet<>();

        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String line = br.readLine();

            for (int j = 0; j < m; j++) {
                if (line.charAt(j) == 'o') {
                    int x = 2000 + i, y = 2000 + j;
                    int z = 10000 * x + y;

                    v.add(z);
                    q1.add(z);
                }
            }
        }

        int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            while (!q1.isEmpty()) {
                int z = q1.poll();
                int x = z / 10000, y = z % 10000;

                for (int[] d : D) {
                    int nx = x + d[0], ny = y + d[1];
                    int nz = 10000 * nx + ny;

                    if (v.add(nz)) q2.add(nz);
                }
            }

            if (q2.isEmpty()) {
                System.out.println(0);
                return;
            }

            Queue<Integer> tmp = q1;
            q1 = q2;
            q2 = tmp;
        }

        System.out.println(v.size());
    }
}