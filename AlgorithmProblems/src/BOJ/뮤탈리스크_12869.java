package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 뮤탈리스크_12869 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] goal = new int[3];
        for (int i = 0; i < n; i++) {
            goal[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][][] v = new boolean[61][61][61];

        Queue<int[]> q1 = new ArrayDeque<>();
        Queue<int[]> q2 = new ArrayDeque<>();

        q1.add(new int[]{0, 0, 0});
        v[0][0][0] = true;

        int[][] D = {{9, 3, 1}, {9, 1, 3}, {3, 9, 1}, {3, 1, 9}, {1, 9, 3}, {1, 3, 9}};

        int t = 0;

        while (!q1.isEmpty()) {
            int[] now = q1.poll();

            if (now[0] >= goal[0] && now[1] >= goal[1] && now[2] >= goal[2]) {
                System.out.println(t);
                return;
            }

            for (int[] d : D) {
                int x = Math.min(60, now[0] + d[0]);
                int y = Math.min(60, now[1] + d[1]);
                int z = Math.min(60, now[2] + d[2]);

                if (v[x][y][z]) continue;

                v[x][y][z] = true;

                q2.add(new int[]{x, y, z});
            }

            if (q1.isEmpty()) {
                Queue<int[]> tmp = q1;
                q1 = q2;
                q2 = tmp;

                t++;
            }
        }
    }
}