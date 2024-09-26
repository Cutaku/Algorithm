package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class 회장뽑기_2660 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] relation = new int[n][n];
         for (int i = 0; i < n; i++) {
             Arrays.fill(relation[i], 50);
             relation[i][i] = 0;
         }

         StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            if (a < 0) break;

            relation[a][b] = relation[b][a] = 1;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (i == k) continue;

                for (int j = 0; j < n; j++) {
                    if (j == k || j == i) continue;

                    relation[i][j] = Math.min(relation[i][j], relation[i][k] + relation[k][j]);
                }
            }
        }

        int min = 50;
        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int max = 0;

            for (int j = 0; j < n; j++) max = Math.max(max, relation[i][j]);

            if (max < min) {
                min = max;
                q.clear();
                q.add(i + 1);
            } else if (max == min) {
                q.add(i + 1);
            }
        }

        System.out.println(min + " " + q.size());

        while (!q.isEmpty()) {
            System.out.print(q.poll() + " ");
        }
    }
}